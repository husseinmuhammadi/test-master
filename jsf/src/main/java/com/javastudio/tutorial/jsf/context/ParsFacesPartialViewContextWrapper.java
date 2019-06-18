package com.javastudio.tutorial.jsf.context;

import com.javastudio.tutorial.jsf.render.ParsFacesPartialResponseWriter;

import javax.faces.context.PartialResponseWriter;
import javax.faces.context.PartialViewContext;
import javax.faces.context.PartialViewContextWrapper;

public class ParsFacesPartialViewContextWrapper extends PartialViewContextWrapper {

    private PartialViewContext wrapped;
    private PartialResponseWriter writer = null;

    public ParsFacesPartialViewContextWrapper(PartialViewContext wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public PartialViewContext getWrapped() {
        return wrapped;
    }

    @Override
    public PartialResponseWriter getPartialResponseWriter() {
        if (writer == null) {
            PartialResponseWriter parentWriter = getWrapped().getPartialResponseWriter();
            writer = new ParsFacesPartialResponseWriter(parentWriter);
        }
        return writer;
    }
}
