package com.javastudio.tutorial.jsf.render;

import com.javastudio.tutorial.jsf.application.RequestContext;

import javax.faces.context.PartialResponseWriter;
import javax.faces.context.ResponseWriter;
import javax.faces.event.AbortProcessingException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ParsFacesPartialResponseWriter extends PartialResponseWriter {
    private PartialResponseWriter wrapped;

    public ParsFacesPartialResponseWriter(PartialResponseWriter writer) {
        super(writer);
        this.wrapped = writer;
    }

    @Override
    public ResponseWriter getWrapped() {
        return wrapped.getWrapped();
    }

    @Override
    public void startDocument() throws IOException {
        wrapped.startDocument();
    }

    @Override
    public void endDocument() throws IOException {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        if (requestContext != null) {
            try {
                getScript(requestContext);
            }
            catch (Exception exception) {
                throw new AbortProcessingException(exception);
            }
        }
        wrapped.endDocument();
    }

    @Override
    public void startInsertBefore(String targetId) throws IOException {
        wrapped.startInsertBefore(targetId);
    }

    @Override
    public void startInsertAfter(String targetId) throws IOException {
        wrapped.startInsertAfter(targetId);
    }

    @Override
    public void endInsert() throws IOException {
        wrapped.endInsert();
    }

    @Override
    public void startUpdate(String targetId) throws IOException {
        wrapped.startUpdate(targetId);
    }

    @Override
    public void endUpdate() throws IOException {
        wrapped.endUpdate();
    }

    @Override
    public void updateAttributes(String targetId, Map<String, String> attributes) throws IOException {
        wrapped.updateAttributes(targetId, attributes);
    }

    @Override
    public void delete(String targetId) throws IOException {
        wrapped.delete(targetId);
    }

    @Override
    public void redirect(String url) throws IOException {
        wrapped.redirect(url);
    }

    @Override
    public void startEval() throws IOException {
        wrapped.startEval();
    }

    @Override
    public void endEval() throws IOException {
        wrapped.endEval();
    }

    @Override
    public void startExtension(Map<String, String> attributes) throws IOException {
        wrapped.startExtension(attributes);
    }

    @Override
    public void endExtension() throws IOException {
        wrapped.endExtension();
    }

    @Override
    public void startError(String errorName) throws IOException {
        wrapped.startError(errorName);
    }

    @Override
    public void endError() throws IOException {
        wrapped.endError();
    }

    @Override
    public void startCDATA() throws IOException {
        wrapped.startCDATA();
    }

    @Override
    public void endCDATA() throws IOException {
        wrapped.endCDATA();
    }

    public void getScript(RequestContext requestContext) throws IOException {
        List<String> scripts = requestContext.getScripts();
        if (!scripts.isEmpty()) {
            startEval();

            for (String script : scripts) {
                write(script);
            }

            endEval();
        }
    }
}
