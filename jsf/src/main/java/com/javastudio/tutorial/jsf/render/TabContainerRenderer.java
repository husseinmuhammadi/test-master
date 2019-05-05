package com.javastudio.tutorial.jsf.render;

import com.javastudio.tutorial.jsf.component.UITab;
import com.javastudio.tutorial.jsf.component.UITabContainer;
import com.javastudio.tutorial.jsf.util.RendererUtil;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.NavigationCase;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@FacesRenderer(componentFamily = UITabContainer.FAMILY, rendererType = UITabContainer.RENDERER_TYPE)
public class TabContainerRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.isNull(context, component);
        if (!component.isRendered()) {
            return;
        }
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("ul", component);
        writer.writeAttribute("class", "nav nav-tabs", null);
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.isNull(context, component);
        if (!component.isRendered()) {
            return;
        }
        UITabContainer uiTabContainer = (UITabContainer) component;
        Map<String, Map<String, Map<String, String>>> srcIdMap = uiTabContainer.getSrcMap();
        if (srcIdMap == null) {
            srcIdMap = new HashMap<>();
            uiTabContainer.setSrcMap(srcIdMap);
        }
        ResponseWriter writer = context.getResponseWriter();
        boolean checkActivation = true;
        for (UIComponent uiComponent : component.getChildren()) {
            if (uiComponent instanceof UITab) {
                UITab uiTab = (UITab) uiComponent;
                writer.startElement("li", uiTab);
                UUID uuid = UUID.randomUUID();
                if (checkActivation && uiTab.isActive()) {
                    checkActivation = false;
                    writer.writeAttribute("class", "active", null);
                    uiTabContainer.setActiveId(uuid.toString());
                }
                writer.startElement("a", uiTab);
                Map<String, Map<String, String>> urlParameters = new HashMap<>();
                Map<String, String> parameters = RendererUtil.getParameterTagValue(uiComponent);

                urlParameters.put(uiTab.getSrc(), parameters);
                srcIdMap.put(uuid.toString(), urlParameters);
                writer.writeAttribute("href", "#" + uuid.toString(), null);
                writer.writeAttribute("data-toggle", "tab", null);
                writer.write(uiTab.getText());
                writer.endElement("a");
                writer.endElement("li");
            }
        }
    }



    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.isNull(context, component);
        if (!component.isRendered()) {
            return;
        }
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("ul");
        UITabContainer uiTabContainer = (UITabContainer) component;
        Map<String, Map<String, Map<String, String>>> srcIdMap = uiTabContainer.getSrcMap();
        Set<Map.Entry<String, Map<String, Map<String, String>>>> entries = srcIdMap.entrySet();
        StringBuilder scripts = new StringBuilder();
        if (entries.size() > 0) {
            writer.startElement("div", component);
            writer.writeAttribute("class", "tab-content", null);
            scripts.append("<script type='text/javascript'>$(function() {");
        }

        for (Map.Entry<String, Map<String, Map<String, String>>> mapEntry : entries) {
            Set<Map.Entry<String, Map<String, String>>> urlParameters = mapEntry.getValue().entrySet();
            Map.Entry<String, Map<String, String>> urlParameterEntry = urlParameters.iterator().next();
            NavigationCase navigationCase = ((ConfigurableNavigationHandler) context.getApplication().getNavigationHandler()).
                    getNavigationCase(context, null, urlParameterEntry.getKey());
            String toViewId = navigationCase.getToViewId(context);
            String uri = context.getApplication().getViewHandler().getBookmarkableURL(context, toViewId, null, false);
            StringBuilder urlParametersString = new StringBuilder();
            for (Map.Entry<String, String> parameter : urlParameterEntry.getValue().entrySet()) {
                if (urlParametersString.length() > 0) {
                    urlParametersString.append("&");
                }
                urlParametersString.append(parameter.getKey()).append("=").append(parameter.getValue());
            }
            String absoluteUrl = ((HttpServletRequest) context.getExternalContext().getRequest()).getRequestURL().toString().
                    replace(((HttpServletRequest) context.getExternalContext().getRequest()).getRequestURI(), "") + uri +
                    (urlParametersString.length() > 0 ? "?" + urlParametersString.toString() : "");
            scripts.append("ajaxRequest('" + absoluteUrl + "','" + mapEntry.getKey() + "');");
            writer.startElement("div", component);
            writer.writeAttribute("id", mapEntry.getKey(), null);
            writer.writeAttribute("class", "tab-pane fade in" + (mapEntry.getKey().equals(uiTabContainer.getActiveId()) ? " active" : ""), null);
            writer.endElement("div");
        }

        uiTabContainer.setSrcMap(null);
        if (entries.size() > 0) {
            writer.endElement("div");
            scripts.append("});</script>");
            writer.append(scripts);
        }

    }
}
