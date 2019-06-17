package com.javastudio.tutorial.jsf.application;

import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

public abstract class RequestContext {
    private static final ThreadLocal<RequestContext> INSTANCE = new ThreadLocal<>();


    // Constants
    public static final String OUT_COME = "outCome";
    public static final String PARAMS = "params";
    public static final String SCRIPT = "script";
    public static final String REPORT_ADDRESS = "reportAddress";


    private static final String KEY = "parsfaces.request";


    public static void setCurrentInstance(final RequestContext requestContext, final FacesContext context) {
        if (requestContext == null) {
            INSTANCE.remove();
            context.getAttributes().remove(KEY);
        } else {
            INSTANCE.set(requestContext);
            FacesContext.getCurrentInstance().getAttributes().put(KEY, requestContext);
        }
    }

    public static RequestContext getCurrentInstance() {
        RequestContext requestContext = INSTANCE.get();
        if (requestContext != null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            if (facesContext != null && !facesContext.isReleased()) {
                requestContext = (RequestContext) facesContext.getAttributes().get(KEY);
                if (requestContext != null) {
                    INSTANCE.set(requestContext);
                }
            }
        }

        // return RequestContext
        return INSTANCE.get();
    }

    public abstract void openDialog(String outCome, Map<String, List<String>> params);

    public abstract void closeDialog(String dialogName);

    public abstract void report();

    public abstract void lookup(String parentId, String text, Object value);

    public abstract List<String> getScripts();

    public abstract Map<Object, Object> getAttributes();

    public static void removeCurrentInstance() {
        INSTANCE.remove();
    }

    public static void releaseCache() {
        INSTANCE.remove();
    }
}
