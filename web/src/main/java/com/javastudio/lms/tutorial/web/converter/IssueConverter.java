package com.javastudio.lms.tutorial.web.converter;

import com.javastudio.lms.tutorial.web.controller.common.SelectItemsController;
import com.javastudio.tutorial.api.IssueService;
import com.javastudio.tutorial.api.UserService;
import com.javastudio.tutorial.dto.Issue;
import com.javastudio.tutorial.dto.User;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class IssueConverter implements Converter {

    @Inject
    SelectItemsController selectItemsController;

    @EJB
    IssueService service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String issueNo) {
        if (issueNo == null || issueNo.isEmpty())
            return null;

        if (issueNo.equals(selectItemsController.getEmptyItem().getLabel()))
            return null;

        return service.findByIssueNo(Long.valueOf(issueNo));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object issue) {
        if (issue == null)
            return null;

        return String.valueOf(((Issue) issue).getIssueNo());
    }
}
