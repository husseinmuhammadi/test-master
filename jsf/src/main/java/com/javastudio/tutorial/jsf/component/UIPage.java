package com.javastudio.tutorial.jsf.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;

@FacesComponent(value = "com.javastudio.tutorial.jsf.component.Page")
@ResourceDependencies({
        @ResourceDependency(library = "faces", name = "js/componentFaces.js")
})
public class UIPage extends UIOutput {
    public static final String FAMILY = "com.javastudio.tutorial.jsf.component";
    public static final String RENDERER_TYPE = "com.javastudio.tutorial.jsf.render.PageRenderer";

    @Override
    public String getRendererType() {
        return RENDERER_TYPE;
    }

    @Override
    public String getFamily() {
        return FAMILY;
    }

    public String getSrc() {
        return  (String) getStateHelper().eval(PropertyKeys.src);
    }

    public void setSrc(String src) {
        getStateHelper().put(PropertyKeys.src, src);
    }

    enum PropertyKeys {
        src,
    }
}
