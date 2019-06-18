package com.javastudio.tutorial.jsf.component;

import com.javastudio.tutorial.jsf.util.MessageUtil;

import javax.faces.application.FacesMessage;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIParameter;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import java.util.*;

@FacesComponent(value = "com.javastudio.tutorial.jsf.component.Lookup")
@ResourceDependencies({
        @ResourceDependency(library = "faces", name = "js/componentFaces.js")})
public class UILookup extends UIInput implements ClientBehaviorHolder {
    public static final String FAMILY = "com.javastudio.tutorial.jsf.component";
    public static final String RENDERER_TYPE = "com.javastudio.tutorial.jsf.render.LookupRenderer";

    @Override
    public String getFamily() {
        return FAMILY;
    }

    @Override
    public String getRendererType() {
        return RENDERER_TYPE;
    }

    public String getLookupPath() {
        return (String) getStateHelper().eval(PropertyKeys.lookupPath);
    }

    public void setLookupPath(String lookupPath) {
        getStateHelper().put(PropertyKeys.lookupPath, lookupPath);
    }

    public String getInputClass() {
        return (String) getStateHelper().eval(PropertyKeys.inputClass);

    }

    public void setInputClass(String inputClass) {
        getStateHelper().put(PropertyKeys.inputClass, inputClass);
    }

    public String getBtnClass() {
        return (String) getStateHelper().eval(PropertyKeys.btnClass);
    }

    public void setBtnClass(String btnClass) {
        getStateHelper().put(PropertyKeys.btnClass, btnClass);
    }

    public String getInputText() {
        return (String) getStateHelper().eval(PropertyKeys.inputClass);
    }

    public void setInputText(String inputText) {
        getStateHelper().put(PropertyKeys.inputClass, inputText);
    }

    public Boolean isReadOnly() {
        return (Boolean) getStateHelper().eval(PropertyKeys.readOnly, Boolean.FALSE);
    }

    public void setReadOnly(Boolean readOnly) {
        getStateHelper().put(PropertyKeys.readOnly, readOnly);
    }

    public UILookup getBinding() {
        return (UILookup) getStateHelper().eval(PropertyKeys.binding);
    }

    public void setBinding(UILookup binding) {
        getStateHelper().put(PropertyKeys.binding, binding);
    }

    public List<UIParameter> getParams() {
        return (List<UIParameter>) getStateHelper().eval(PropertyKeys.params, new ArrayList<>());
    }

    public void setParams(List<UIParameter> params) {
        getStateHelper().put(PropertyKeys.params, params);
    }

    @Override
    public void processValidators(FacesContext context) {
        if (!isReadOnly() && isRendered() && isRequired()) {
            if (isEmpty(getValue())) {
                String requiredMessageStr = getRequiredMessage();
                FacesMessage message;
                if (null != requiredMessageStr) {
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, requiredMessageStr, requiredMessageStr);
                } else {
                    message = MessageUtil.getMessage(context, REQUIRED_MESSAGE_ID, MessageUtil.getLabel(context, this));
                }
                context.addMessage(getClientId(context), message);
                setValid(false);
            }
        }
    }

    private final static Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("valueChange"));

    @Override
    public Collection<String> getEventNames() {
        return EVENT_NAMES;
    }

    @Override
    public String getDefaultEventName() {
        return "valueChange";
    }


    protected enum PropertyKeys {
        lookupPath,
        inputClass,
        btnClass,
        inputText,
        readOnly,
        params,
        binding;
    }
}
