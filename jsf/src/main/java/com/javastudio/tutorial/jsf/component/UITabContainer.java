package com.javastudio.tutorial.jsf.component;

import com.javastudio.tutorial.jsf.type.AsyncHttpRequest;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import java.util.Map;

@FacesComponent(value = "com.javastudio.tutorial.jsf.component.TabContainer")
@ResourceDependencies({
        @ResourceDependency(library = "faces", name = "js/componentFaces.js")
})
public class UITabContainer extends UIOutput {
    public static final String FAMILY = "com.javastudio.tutorial.jsf.component";
    public static final String RENDERER_TYPE = "com.javastudio.tutorial.jsf.render.TabContainerRenderer";
    private String activeId;

    @Override
    public boolean getRendersChildren() {
        return true;
    }

    @Override
    public String getRendererType() {
        return RENDERER_TYPE;
    }

    public Map<String, AsyncHttpRequest> getSrcMap() {
        return (Map<String, AsyncHttpRequest>) getStateHelper().eval(PropertyKeys.srcMap);
    }

    public void setSrcMap(Map<String, AsyncHttpRequest> srcMap) {
        getStateHelper().put(PropertyKeys.srcMap, srcMap);
    }

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    @Override
    public String getFamily() {
        return FAMILY;
    }

    public enum PropertyKeys {
        srcMap;
    }
}
