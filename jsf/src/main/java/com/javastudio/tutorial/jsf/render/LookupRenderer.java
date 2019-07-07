package com.javastudio.tutorial.jsf.render;

import com.javastudio.tutorial.jsf.component.FacesComponent;
import com.javastudio.tutorial.jsf.component.UILookup;
import com.javastudio.tutorial.jsf.util.RendererUtil;
import com.javastudio.tutorial.jsf.util.ScriptUtil;

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
        super.decode(context, component);
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
        writer.writeAttribute("data-toggle", "modal", null);
        writer.writeAttribute("data-target", "#exampleModalLong", null);
        if (bindingLookup != null && bindingLookup.isReadOnly()) {
            writer.writeAttribute("readonly", "readonly", null);
        } else if (uiLookup.isReadOnly() == null || !uiLookup.isReadOnly()) {
            String url = context.getApplication().getViewHandler().getBookmarkableURL(context, uiLookup.getLookupPath(), null, false);
            StringBuilder parameters = new StringBuilder();
            parameters.append("?parentId=");
            parameters.append(clientId);
            parameters.append("&t=0");
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
            writer.writeAttribute("onclick", ScriptUtil.returnDialogBuilder(url + parameters.toString()), null);
        } else {
            writer.writeAttribute("readonly", "readonly", null);
        }
        writer.writeAttribute("id", buttonId, null);
        if (uiLookup.getBtnClass() != null && uiLookup.getBtnClass().length() > 0) {
            writer.writeAttribute("class", uiLookup.getBtnClass(), null);
        }
        writer.write("...");
        writer.endElement("button");
        writer.endElement("div");
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.isNull(context, component);
        if (!component.isRendered()) {
            return;
        }

        ResponseWriter writer = context.getResponseWriter();

        /*
        <input id="organization-chart-form:userId" type="text" disabled="disabled" value="form-control" class="form-control"></input>
                    <input id="organization-chart-form:userId_hdn" type="hidden" name="organization-chart-form:userId_hdn"></input>
                    <div id="organization-chart-form:userId_btn_div" class="input-group-append">
                        <button id="organization-chart-form:userId_btn" class="btn btn-default btn-outline-secondary" type="button" data-toggle="modal" data-target="#lookup">...</button>
                    </div>
                    */
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.isNull(context, component);
        if (!component.isRendered()) {
            return;
        }
        ResponseWriter writer = context.getResponseWriter();

        renderModalDialog("dialog");
    }

    private void renderModalDialog(String dialogPanelGroupId) {
        UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent dialog = view.findComponent(dialogPanelGroupId);
        if (dialog != null) {
            FacesComponent.includeCompositeComponent(dialog, "composite", "test.xhtml", "lookupModal");
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
