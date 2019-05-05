package com.javastudio.tutorial.jsf.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import java.util.Map;

@FacesComponent(value = "ir.javadev.jsf.parsfaces.component.TabContainer")
@ResourceDependencies({
        @ResourceDependency(library = "faces", name = "js/componentFaces.js")
})
public class UITabContainer extends UIOutput {
    public static final String FAMILY = "ir.javadev.jsf.parsfaces.component";
    public static final String RENDERER_TYPE = "ir.javadev.jsf.renderer.TabContainerRenderer";
    private String activeId;

    @Override
    public boolean getRendersChildren() {
        return true;
    }

    @Override
    public String getRendererType() {
        return RENDERER_TYPE;
    }

    public Map<String, Map<String, Map<String, String>>> getSrcMap() {
        return (Map<String, Map<String, Map<String, String>>>) getStateHelper().eval(PropertyKeys.srcMap);
    }

    public void setSrcMap(Map<String, Map<String, Map<String, String>>> srcMap) {
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
