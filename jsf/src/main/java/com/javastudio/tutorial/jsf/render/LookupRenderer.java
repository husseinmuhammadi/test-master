package com.javastudio.tutorial.jsf.render;

import com.javastudio.tutorial.jsf.component.FacesComponent;
import com.javastudio.tutorial.jsf.component.UILookup;
import com.javastudio.tutorial.jsf.util.RendererUtil;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.component.UIViewRoot;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import java.io.IOException;
import java.util.*;

@FacesRenderer(componentFamily = UILookup.FAMILY, rendererType = UILookup.RENDERER_TYPE)
public class LookupRenderer extends RendererBase {

    @Override
    public void decode(FacesContext context, UIComponent component) {
        RendererUtil.isNull(context, component);
        if (!component.isRendered()) {
            return;
        }

        String clientId = component.getClientId();
        Object value = context.getExternalContext().getRequestParameterMap().get(clientId.concat("_hdn"));
        if (value != null && !"".equals(value.toString().trim())) {
            ((UILookup) component).setValue(value);
        }

        Object inputText = context.getExternalContext().getRequestParameterMap().get(clientId);
        if (inputText != null) {
            ((UILookup) component).setInputText(inputText.toString());
        }

        decodeBehaviors(context, component);
    }

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.isNull(context, component);

        if (!component.isRendered()) {
            return;
        }

        ResponseWriter writer = context.getResponseWriter();
        UILookup uiLookup = (UILookup) component;

        UILookup bindingLookup = null;
        if (uiLookup.getBinding() != null) {
            bindingLookup = uiLookup.getBinding();
        }

        String clientId = component.getClientId();
        writer.startElement("input", component);
        writer.writeAttribute("type", "text", null);
        writer.writeAttribute("id", clientId, null);
        writer.writeAttribute("readonly", "readonly", null);

        Map<String, List<ClientBehavior>> clientBehaviors = ((ClientBehaviorHolder) component).getClientBehaviors();
        if (null != clientBehaviors) {
            for (Map.Entry<String, List<ClientBehavior>> clientBehaviorSet : clientBehaviors.entrySet()) {
                List<ClientBehavior> clientBehaviorList = clientBehaviorSet.getValue();
                Collection<ClientBehaviorContext.Parameter> parameters = Collections.unmodifiableCollection(Arrays.asList());
                for (ClientBehavior clientBehavior : clientBehaviorList) {
                    String script = clientBehavior.getScript(
                            ClientBehaviorContext.createClientBehaviorContext(context, component, clientBehaviorSet.getKey(),
                                    component.getClientId(context), parameters));
                    writer.writeAttribute("onchange", script, null);
                }
            }
        }

        if (bindingLookup != null && bindingLookup.getInputText() != null) {
            writer.writeAttribute("value", bindingLookup.getInputText(), null);
        }
        if (uiLookup.getInputClass() != null && uiLookup.getInputClass().length() > 0) {
            writer.writeAttribute("class", uiLookup.getInputClass(), null);
        }
        writer.endElement("input");

        String hiddenFieldId = clientId + "_hdn";
        writer.startElement("input", component);
        writer.writeAttribute("type", "hidden", null);
        writer.writeAttribute("id", hiddenFieldId, null);
        writer.writeAttribute("name", hiddenFieldId, null);
        if (bindingLookup != null && bindingLookup.getValue() != null) {
            writer.writeAttribute("value", uiLookup.getValue(), null);
        }
        writer.endElement("input");

        String buttonId = clientId + "_btn";
        String buttonSpanId = buttonId + "_spn";

        writer.startElement("div", component);
        writer.writeAttribute("id", buttonSpanId, null);
        writer.writeAttribute("class", "input-group-append", null);
        writer.startElement("button", component);
        writer.writeAttribute("type", "button", null);
        writer.writeAttribute("data-toggle", "modal", null);
        writer.writeAttribute("data-target", "#lookup", null);
        if (bindingLookup != null && bindingLookup.isReadOnly()) {
            writer.writeAttribute("readonly", "readonly", null);
        } else if (uiLookup.isReadOnly() != null && uiLookup.isReadOnly()) {
            writer.writeAttribute("readonly", "readonly", null);
        }
        writer.writeAttribute("id", buttonId, null);
        if (uiLookup.getBtnClass() != null && uiLookup.getBtnClass().length() > 0) {
            writer.writeAttribute("class", uiLookup.getBtnClass(), null);
        }
        writer.write("...");
        writer.endElement("button");
        writer.endElement("div");

        String url = context.getApplication().getViewHandler().getBookmarkableURL(context, uiLookup.getLookupPath(), null, false);
        StringBuilder parameters = new StringBuilder();
        parameters.append("?parentId=").append(clientId);
        parameters.append("&partial=0");
        Map<String, String> parameterTagValue = RendererUtil.getParameterTagValue(component);
        List<UIParameter> params = uiLookup.getParams();
        if (params.size() > 0) {
            for (UIParameter param : params) {
                parameterTagValue.put(param.getName(), param.getValue().toString());
            }
        }
        for (Map.Entry<String, String> entry : parameterTagValue.entrySet()) {
            parameters.append("&");
            parameters.append(entry.getKey());
            parameters.append("=");
            parameters.append(entry.getValue());
        }
        // writer.writeAttribute("onclick", ScriptUtil.returnDialogBuilder(url + parameters.toString()), null);

        renderLookupModal("dialog", "Select a user from a list", url + parameters.toString(), UUID.randomUUID().toString());
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.isNull(context, component);
        if (!component.isRendered()) {
            return;
        }

        ResponseWriter writer = context.getResponseWriter();
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.isNull(context, component);
        if (!component.isRendered()) {
            return;
        }

        ResponseWriter writer = context.getResponseWriter();
    }

    private void renderLookupModal(String dialogContainerId, String title, String asyncHttpRequestUrl, String asyncHttpRequestUniqueId) {
        UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent dialog = view.findComponent(dialogContainerId);
        if (dialog != null) {
            FacesComponent.includeCompositeComponentAndSetValueExpression(dialog, "composite", "dialog.xhtml", "lookupModal", title, asyncHttpRequestUrl, asyncHttpRequestUniqueId);
        }
    }

    private HtmlPanelGroup createHtmlDivElement() {
        HtmlPanelGroup div = new HtmlPanelGroup();
        div.setLayout("block");
        return div;
    }

    void addOutputText(UIComponent parent) {
        HtmlOutputText outputText = new HtmlOutputText();
        outputText.setValue("Hello");
        parent.getChildren().add(outputText);
    }
}
