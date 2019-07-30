package com.javastudio.tutorial.jsf.render;

import com.javastudio.tutorial.jsf.component.UIPage;
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
import java.util.Map;
import java.util.UUID;

@FacesRenderer(componentFamily = UIPage.FAMILY, rendererType = UIPage.RENDERER_TYPE)
public class PageRenderer extends Renderer {
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.isNull(context, component);
        if (!component.isRendered()) {
            return;
        }
        ResponseWriter writer = context.getResponseWriter();

        UIPage uiTab = (UIPage) component;

        UUID uuid = UUID.randomUUID();

        Map<String, String> parameters = RendererUtil.getParameterTagValue(component);
        AsyncHttpRequest asyncHttpRequest = new AsyncHttpRequest(uiTab.getSrc(), parameters);

        StringBuilder scripts = new StringBuilder();
        String absoluteUrl = getAbsoluteUrl(context, asyncHttpRequest);
        scripts.append("<script type='text/javascript'>$(function() {");
        scripts.append("ajaxRequest('").append(absoluteUrl).append("','").append(uuid.toString()).append("');");
        writer.startElement("div", component);
        writer.writeAttribute("id", uuid.toString(), null);
        writer.endElement("div");
        scripts.append("});</script>");
        writer.append(scripts);
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
