package com.javastudio.tutorial.jsf.util;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonParser;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RendererUtil {
    public static void isNull(FacesContext context, UIComponent component) {
        if (context == null || component == null) {
            throw new NullPointerException();
        }
    }

    public static JsonObjectBuilder jsonParameterParser(String json, FacesContext context) {
        StringReader stringReader = new StringReader(json);
        JsonParser jsonParser = Json.createParser(stringReader);
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();
            if (event.equals(JsonParser.Event.START_OBJECT)) {
                String key = null;
                while (jsonParser.hasNext() && !(event = jsonParser.next()).equals(JsonParser.Event.END_OBJECT)) {
                    if (event.equals(JsonParser.Event.KEY_NAME)) {
                        key = jsonParser.getString();
                    } else if (event.equals(JsonParser.Event.VALUE_STRING)) {
                        String value = jsonParser.getString();
                        if (value.startsWith("#")) {
                            value = context.getApplication().evaluateExpressionGet(context, value, String.class);
                        }

                        jsonObjectBuilder.add(key, value);
                    }
                }
            }
        }
        return jsonObjectBuilder;
    }

    public static void encodeRecursive(FacesContext context, UIComponent component)
            throws IOException {

        // suppress rendering if "rendered" property on the component is
        // false.
        if (!component.isRendered()) {
            return;
        }

        // Render this component and its children recursively
        component.encodeBegin(context);
        if (component.getRendersChildren()) {
            component.encodeChildren(context);
        } else {
            Iterator<UIComponent> kids = getChildren(component);
            while (kids.hasNext()) {
                UIComponent kid = kids.next();
                encodeRecursive(context, kid);
            }
        }
        component.encodeEnd(context);

    }

    public static Iterator<UIComponent> getChildren(UIComponent component) {

        int childCount = component.getChildCount();
        if (childCount > 0) {
            return component.getChildren().iterator();
        } else {
            return Collections.<UIComponent>emptyList().iterator();
        }

    }

    public static Map<String, String> getParameterTagValue(UIComponent uiComponent) {
        Map<String, String> parameters = new HashMap<>();
        for (UIComponent child : uiComponent.getChildren()) {
            if (child instanceof UIParameter) {
                UIParameter uiParameter = (UIParameter) child;
                if (!uiParameter.isDisable()) {
                    if (uiParameter.getValue() != null) {
                        parameters.put(uiParameter.getName(), uiParameter.getValue().toString());
                    }
                }
            }
        }
        return parameters;
    }
}
