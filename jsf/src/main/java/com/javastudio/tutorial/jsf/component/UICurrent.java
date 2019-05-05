package com.javastudio.tutorial.jsf.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@FacesComponent(UICurrent.COMPONENT_TYPE)
public class UICurrent extends UIComponentBase {

    public static final String FAMILY = "com.javastudio.tutorial.jsf.component";
    public static final String COMPONENT_TYPE = "com.javastudio.tutorial.jsf.component.UICurrent";

    @Override
    public String getFamily() {
        return FAMILY;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        LocalDateTime time = (LocalDateTime) getAttributes().get("time");
        String formattedTime = time.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

        ResponseWriter writer = context.getResponseWriter();

        writer.startElement("p", this);
        writer.write("Time: " + formattedTime);
        writer.endElement("p");
    }
}
