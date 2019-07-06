package com.javastudio.tutorial.jsf.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIParameter;
import javax.faces.component.behavior.ClientBehaviorHolder;
import java.util.ArrayList;
import java.util.List;

@FacesComponent(value = "com.javastudio.tutorial.jsf.component.Lookup")
@ResourceDependencies({
        @ResourceDependency(library = "faces", name = "js/componentFaces.js")
})
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

    // region Getters & Setters

    public UILookup getBinding() {
        return (UILookup) getStateHelper().eval(UILookup.PropertyKeys.binding);
    }

    public void setBinding(UILookup binding) {
        getStateHelper().put(UILookup.PropertyKeys.binding, binding);
    }

    public String getInputText() {
        return (String) getStateHelper().eval(PropertyKeys.inputText);
    }

    public void setInputText(String inputText) {
        getStateHelper().put(PropertyKeys.inputText, inputText);
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

    public Boolean isReadOnly() {
        return (Boolean) getStateHelper().eval(PropertyKeys.readOnly, Boolean.FALSE);
    }

    public void setReadOnly(Boolean readOnly) {
        getStateHelper().put(PropertyKeys.readOnly, readOnly);
    }

    public String getLookupPath() {
        return (String) getStateHelper().eval(PropertyKeys.lookupPath);
    }

    public void setLookupPath(String lookupPath) {
        getStateHelper().put(PropertyKeys.lookupPath, lookupPath);
    }

    public List<UIParameter> getParams() {
        return (List<UIParameter>) getStateHelper().eval(PropertyKeys.params, new ArrayList<>());
    }

    public void setParams(List<UIParameter> params) {
        getStateHelper().put(PropertyKeys.params, params);
    }

    // endregion Getters & Setters

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

