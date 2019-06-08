package com.javastudio.tutorial.jsf.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;

@FacesComponent(value = "com.javastudio.tutorial.jsf.component.Tab")
public class UITab extends UIOutput {
    public static final String FAMILY = "com.javastudio.tutorial.jsf.component";
    public static final String RENDERER_TYPE = null;

    @Override
    public String getRendererType() {
        return RENDERER_TYPE;
    }

    @Override
    public String getFamily() {
        return FAMILY;
    }

    public Boolean isActive() {
        return (Boolean) getStateHelper().eval(PropertyKeys.active);
    }

    public void setActive(Boolean active) {
        getStateHelper().put(PropertyKeys.active, active);
    }

    public String getSrc() {
        return  (String) getStateHelper().eval(PropertyKeys.src);
    }

    public void setSrc(String src) {
        getStateHelper().put(PropertyKeys.src, src);
    }

    public String getText() {
        return (String) getStateHelper().eval(PropertyKeys.text);
    }

    public void setText(String text) {
        getStateHelper().put(PropertyKeys.text, text);
    }

    enum PropertyKeys {
        active,
        src,
        text;
    }
}
