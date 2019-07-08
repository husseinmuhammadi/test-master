package com.javastudio.tutorial.jsf.application;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParsRequestContext extends RequestContext {

    private Map<Object, Object> attrs;
    private FacesContext context;

    public ParsRequestContext(FacesContext facesContext) {
        this.context = facesContext;
        attrs = new HashMap<>();
        String reportAddress = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("ir.javadev.jsf.component.report.address");
        if (reportAddress != null && reportAddress.length() > 0) {
            attrs.put(REPORT_ADDRESS, reportAddress);
        }
    }

    public void openDialog(String outCome, Map<String, List<String>> params) {
        attrs.put(OUT_COME, outCome);
        if (params != null && !params.isEmpty()) {
            attrs.put(PARAMS, params);
        }
    }

    @Override
    public void closeDialog(String dialogName) {
        getScripts().add("closeDialog('" + dialogName + "')");
    }

    @Override
    public void report() {
        String reportAddress = (String) attrs.get(REPORT_ADDRESS);
        if (reportAddress != null && reportAddress.length() > 0) {
            String url = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath() + reportAddress;
            getScripts().add("$(function(){window.open('" + url + "','_blank');});");
        } else {
            throw new RuntimeException("The 'ir.javadev.jsf.component.report.address' param context is not set");
        }
    }

    @Override
    public void lookup(String parentId, String text, Object value) {
        // TODO: correct this using javax.faces.SEPARATOR_CHAR in web.xml
        parentId = parentId.replace(":", "\\\\:");
        getCurrentInstance().getScripts().add("$(function(){$('#" + parentId + "').val('" + text + "');");
//        getCurrentInstance().getScripts().add("$('#" + parentId + "').trigger('change');");
        getCurrentInstance().getScripts().add("$('#" + parentId + "_hdn').val('" + value + "');");
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("var buttons = $('button.myclose');");
//        stringBuilder.append("$(buttons[buttons.length - 1]).trigger('click');");
//        getCurrentInstance().getScripts().add(stringBuilder.toString());
        getCurrentInstance().getScripts().add("$('#lookup').modal('hide');");
        getCurrentInstance().getScripts().add("$('#" + parentId + "').change();});");
    }

    public List<String> getScripts() {
        if (attrs.get(SCRIPT) == null) {
            attrs.put(SCRIPT, new ArrayList<String>());
        }
        return (List<String>) attrs.get(SCRIPT);
    }

    @Override
    public Map<Object, Object> getAttributes() {
        return attrs;
    }
}
