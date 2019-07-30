package com.javastudio.lms.tutorial.web.converter;

import com.javastudio.lms.tutorial.web.controller.common.SelectItemsController;
import com.javastudio.tutorial.api.TestCaseService;
import com.javastudio.tutorial.api.TestPlanService;
import com.javastudio.tutorial.dto.TestCase;
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
public class TestCaseConverter implements Converter {

    @Inject
    SelectItemsController selectItemsController;

    @EJB
    TestCaseService service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String id) {
        if (id == null || id.isEmpty())
            return null;

        if (id.equals(selectItemsController.getEmptyItem().getLabel()))
            return null;

        return service.find(Long.valueOf(id));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object testCase) {
        if (testCase == null)
            return null;

        return String.valueOf(((TestCase) testCase).getId());
    }
}
