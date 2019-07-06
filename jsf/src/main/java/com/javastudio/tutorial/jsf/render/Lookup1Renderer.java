package com.javastudio.tutorial.jsf.render;

import com.javastudio.tutorial.jsf.component.UILookup1;
import com.javastudio.tutorial.jsf.util.RendererUtil;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import java.io.IOException;

@FacesRenderer(componentFamily = UILookup1.FAMILY, rendererType = UILookup1.RENDERER_TYPE)
public class Lookup1Renderer extends RendererBase {

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
        UILookup1 uiLookup1 = (UILookup1) component;

        UILookup1 bindingLookup = null;
        if (uiLookup1.getBinding() != null) {
            bindingLookup = uiLookup1.getBinding();
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        super.encodeChildren(context, component);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        super.encodeEnd(context, component);
    }
}
