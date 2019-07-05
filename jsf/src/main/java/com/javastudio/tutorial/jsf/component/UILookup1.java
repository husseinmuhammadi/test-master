package com.javastudio.tutorial.jsf.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;

@FacesComponent(value = "com.javastudio.tutorial.jsf.component.Lookup1")
public class UILookup1 extends UIInput {

    public static final String FAMILY = "com.javastudio.tutorial.jsf.component";
    public static final String RENDERER_TYPE = "com.javastudio.tutorial.jsf.render.Lookup1Renderer";

    @Override
    public String getFamily() {
        return FAMILY;
    }

    @Override
    public String getRendererType() {
        return RENDERER_TYPE;
    }


}

