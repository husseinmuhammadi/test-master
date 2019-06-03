package com.javastudio.tutorial.jsf.render;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;
import java.util.List;
import java.util.Map;

public class BaseRenderer extends Renderer {
    protected final String decodeBehaviors(FacesContext context, UIComponent component) {

        if (!(component instanceof ClientBehaviorHolder)) {
            return null;
        }

        ClientBehaviorHolder holder = (ClientBehaviorHolder) component;
        Map<String, List<ClientBehavior>> behaviors = holder.getClientBehaviors();
        if (behaviors.isEmpty()) {
            return null;
        }

        ExternalContext external = context.getExternalContext();
        Map<String, String> params = external.getRequestParameterMap();
        String behaviorEvent = params.get("javax.faces.behavior.event");

        if (null != behaviorEvent) {
            List<ClientBehavior> behaviorsForEvent = behaviors.get(behaviorEvent);

            if (behaviorsForEvent != null && behaviorsForEvent.size() > 0) {
                String behaviorSource = params.get("javax.faces.source");
                String clientId = component.getClientId();
                if (isBehaviorSource(context, behaviorSource, clientId)) {
                    for (ClientBehavior behavior : behaviorsForEvent) {
                        behavior.decode(context, component);
                    }
                }

                return clientId;
            }
        }

        return null;
    }

    protected boolean isBehaviorSource(FacesContext ctx,
                                       String behaviorSourceId,
                                       String componentClientId) {

        return (behaviorSourceId != null && behaviorSourceId.equals(componentClientId));

    }
}
