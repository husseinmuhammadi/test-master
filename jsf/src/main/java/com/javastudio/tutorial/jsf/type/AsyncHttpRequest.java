package com.javastudio.tutorial.jsf.type;

import java.util.HashMap;
import java.util.Map;

public class AsyncHttpRequest {
    String url;
    Map<String, String> parameters = new HashMap<>();

    public AsyncHttpRequest(String url) {
        this.url = url;
    }

    public AsyncHttpRequest(String url, Map<String, String> parameters) {
        this.url = url;
        this.parameters = parameters;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
