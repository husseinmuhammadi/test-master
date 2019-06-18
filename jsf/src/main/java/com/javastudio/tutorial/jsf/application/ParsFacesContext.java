package com.javastudio.tutorial.jsf.application;

import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextWrapper;


public class ParsFacesContext extends FacesContextWrapper {

    private final FacesContext wrapped;

    public ParsFacesContext(FacesContext facesContext) {
        this.wrapped = facesContext;
        RequestContext.setCurrentInstance(new ParsRequestContext(wrapped), facesContext);
    }

    @Override
    public FacesContext getWrapped() {
        return wrapped;
    }

    @Override
    public void release() {
        RequestContext.releaseCache();
        wrapped.release();
    }
}
