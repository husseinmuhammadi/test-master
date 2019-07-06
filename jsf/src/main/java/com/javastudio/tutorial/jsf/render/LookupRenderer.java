package com.javastudio.tutorial.jsf.render;

import com.javastudio.tutorial.jsf.component.UILookup;
import com.javastudio.tutorial.jsf.util.RendererUtil;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
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
        writer.endElement("input");
    }
}
