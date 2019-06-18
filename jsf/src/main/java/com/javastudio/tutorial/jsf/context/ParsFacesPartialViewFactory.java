package com.javastudio.tutorial.jsf.context;

import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.context.PartialViewContextFactory;

public class ParsFacesPartialViewFactory extends PartialViewContextFactory {

    private PartialViewContextFactory factory;

    public ParsFacesPartialViewFactory() {
    }

    public ParsFacesPartialViewFactory(PartialViewContextFactory factory) {
        this.factory = factory;
    }

    @Override
    public PartialViewContextFactory getWrapped() {
        return this.factory;
    }

    @Override
    public PartialViewContext getPartialViewContext(FacesContext context) {
        PartialViewContext partialViewContext = getWrapped().getPartialViewContext(context);
        return new ParsFacesPartialViewContextWrapper(partialViewContext);
    }
}
