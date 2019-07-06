package com.javastudio.tutorial.jsf.render;

import com.javastudio.tutorial.jsf.component.UITab;
import com.javastudio.tutorial.jsf.component.UITabContainer;
import com.javastudio.tutorial.jsf.type.AsyncHttpRequest;
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
        writer.startElement("nav", component);
        writer.startElement("div", component);
        writer.writeAttribute("class", "nav nav-tabs nav-fill", null);
        writer.writeAttribute("id", "nav-tab", null);
        writer.writeAttribute("role", "tablist", null);
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.isNull(context, component);
        if (!component.isRendered()) {
            return;
        }
        UITabContainer uiTabContainer = (UITabContainer) component;
        Map<String, AsyncHttpRequest> asyncHttpRequestMap = uiTabContainer.getSrcMap();
        if (asyncHttpRequestMap == null) {
            asyncHttpRequestMap = new HashMap<>();
            uiTabContainer.setSrcMap(asyncHttpRequestMap);
        }
        ResponseWriter writer = context.getResponseWriter();
        for (UIComponent uiComponent : component.getChildren()) {
            if (uiComponent instanceof UITab) {
                UITab uiTab = (UITab) uiComponent;

                writer.startElement("a", uiTab);

                boolean active = uiTab.isActive() == null ? false : uiTab.isActive();

                UUID uuid = UUID.randomUUID();

                if (active) {
                    uiTabContainer.setActiveId(uuid.toString());
                }

                Map<String, String> parameters = RendererUtil.getParameterTagValue(uiComponent);
                AsyncHttpRequest asyncHttpRequest = new AsyncHttpRequest(uiTab.getSrc(), parameters);

                asyncHttpRequestMap.put(uuid.toString(), asyncHttpRequest);
                writer.writeAttribute("class", active ? "nav-item nav-link active" : "nav-item nav-link", null);
                writer.writeAttribute("id", "nav-" + uuid.toString() + "-tab", null);
                writer.writeAttribute("href", "#" + uuid.toString(), null);
                writer.writeAttribute("data-toggle", "tab", null);
                writer.writeAttribute("role", "tab", null);
                writer.writeAttribute("aria-controls", uuid.toString(), null);
                writer.writeAttribute("aria-selected", active ? "true" : "false", null);

                writer.write(uiTab.getText());
                writer.endElement("a");
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
        writer.endElement("div");
        writer.endElement("nav");

        UITabContainer uiTabContainer = (UITabContainer) component;
        Map<String, AsyncHttpRequest> asyncHttpRequestMap = uiTabContainer.getSrcMap();
        Set<Map.Entry<String, AsyncHttpRequest>> entries = asyncHttpRequestMap.entrySet();

        StringBuilder scripts = new StringBuilder();

        if (entries.size() > 0) {
            writer.startElement("div", component);
            writer.writeAttribute("class", "tab-content", null);
            scripts.append("<script type='text/javascript'>$(function() {");
        }

        asyncHttpRequestMap.forEach((href, asyncHttpRequest) -> {
            try {
                String absoluteUrl = getAbsoluteUrl(context, asyncHttpRequest);
                scripts.append("ajaxRequest('" + absoluteUrl + "','" + href + "');");
                writer.startElement("div", component);
                writer.writeAttribute("id", href, null);
                writer.writeAttribute("class", "tab-pane fade" + (href.equals(uiTabContainer.getActiveId()) ? " show active" : ""), null);
                writer.writeAttribute("aria-labelledby", "nav-" + href + "-tab", null);
                writer.endElement("div");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        uiTabContainer.setSrcMap(null);
        if (entries.size() > 0) {
            writer.endElement("div");
            scripts.append("});</script>");
            writer.append(scripts);
        }
    }

    String getAbsoluteUrl(FacesContext context, AsyncHttpRequest asyncHttpRequest) {
        NavigationCase navigationCase = ((ConfigurableNavigationHandler) context.getApplication().getNavigationHandler()).
                getNavigationCase(context, null, asyncHttpRequest.getUrl());
        String toViewId = navigationCase.getToViewId(context);
        String uri = context.getApplication().getViewHandler().getBookmarkableURL(context, toViewId, null, false);
        StringBuilder urlParametersString = new StringBuilder();
        for (Map.Entry<String, String> parameter : asyncHttpRequest.getParameters().entrySet()) {
            if (urlParametersString.length() > 0) {
                urlParametersString.append("&");
            }
            urlParametersString.append(parameter.getKey()).append("=").append(parameter.getValue());
        }
        String absoluteUrl = ((HttpServletRequest) context.getExternalContext().getRequest()).getRequestURL().toString().
                replace(((HttpServletRequest) context.getExternalContext().getRequest()).getRequestURI(), "") + uri +
                (urlParametersString.length() > 0 ? "?" + urlParametersString.toString() : "");

        return absoluteUrl;
    }
}
