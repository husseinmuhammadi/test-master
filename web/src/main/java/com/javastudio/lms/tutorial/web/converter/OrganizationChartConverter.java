package com.javastudio.lms.tutorial.web.converter;

import com.javastudio.lms.tutorial.web.controller.common.SelectItemsController;
import com.javastudio.tutorial.api.OrganizationChartService;
import com.javastudio.tutorial.dto.OrganizationChartDTO;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class OrganizationChartConverter implements Converter {

    @Inject
    SelectItemsController selectItemsController;

    @EJB
    OrganizationChartService service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String organizationDescriptor) {
        if (organizationDescriptor.equals(selectItemsController.getEmptyItem().getLabel()))
            return null;

        String[] descriptor = organizationDescriptor.split(":");
        String corporateId = descriptor[0];
        String title = descriptor[1];
        String username = descriptor[2].equals("reserved") ? null : descriptor[2];


        return service.findByOrganizationDescriptor(corporateId, title, username);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        if (o == null)
            return null;

        OrganizationChartDTO organizationChart = (OrganizationChartDTO) o;

        String corporateId = organizationChart.getCorporateId();
        String title = organizationChart.getTitle();
        String username = organizationChart.getUser() == null ? "reserved" : organizationChart.getUser().getUsername();

        return String.format("%s:%s:%s", corporateId, title, username);
    }
}
