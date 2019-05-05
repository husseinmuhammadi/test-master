package com.javastudio.tutorial.jsf.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;

@FacesComponent(UIGreeting.COMPONENT_TYPE)
public class UIGreeting extends UIComponentBase {

    public static final String FAMILY = "com.javastudio.tutorial.jsf.component";
    public static final String COMPONENT_TYPE = "com.javastudio.tutorial.jsf.component.UIGreeting";

    @Override
    public String getFamily() {
        return FAMILY;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();

        writer.startElement("p", this);
        writer.write("Hello!!!");
        writer.endElement("p");
    }
}
