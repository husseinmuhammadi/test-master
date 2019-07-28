package com.javastudio.lms.tutorial.web.converter;

import com.javastudio.lms.tutorial.web.controller.common.SelectItemsController;
import com.javastudio.tutorial.api.IssueService;
import com.javastudio.tutorial.api.TestPlanService;
import com.javastudio.tutorial.dto.Issue;
import com.javastudio.tutorial.dto.TestPlan;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class TestPlanConverter implements Converter {

    @Inject
    SelectItemsController selectItemsController;

    @EJB
    TestPlanService service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String id) {
        if (id == null || id.isEmpty())
            return null;

        if (id.equals(selectItemsController.getEmptyItem().getLabel()))
            return null;

        return service.find(Long.valueOf(id));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object testPlan) {
        if (testPlan == null)
            return null;

        return String.valueOf(((TestPlan) testPlan).getId());
    }
}
