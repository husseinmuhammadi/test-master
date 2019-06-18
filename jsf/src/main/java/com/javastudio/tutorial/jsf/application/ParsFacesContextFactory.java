package com.javastudio.tutorial.jsf.application;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;

public class ParsFacesContextFactory extends FacesContextFactory {

    FacesContextFactory factory;

    public ParsFacesContextFactory() {

    }

    public ParsFacesContextFactory(FacesContextFactory facesContextFactory) {
        this.factory = facesContextFactory;
    }

    @Override
    public FacesContext getFacesContext(Object context, Object request, Object response, Lifecycle lifecycle) throws FacesException {
        FacesContext wrappedContext = factory.getFacesContext(context, request, response, lifecycle);
        if (wrappedContext instanceof ParsFacesContext) {
            return wrappedContext;
        }

        return new ParsFacesContext(wrappedContext);
    }
}
