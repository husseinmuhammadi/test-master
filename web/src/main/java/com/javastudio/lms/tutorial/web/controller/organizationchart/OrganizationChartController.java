package com.javastudio.lms.tutorial.web.controller.organizationchart;

import com.javastudio.lms.tutorial.web.annotation.ShiroSecured;
import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.lms.tutorial.web.security.BCryptPasswordService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.OrganizationChartService;
import com.javastudio.tutorial.api.PersonService;
import com.javastudio.tutorial.dto.OrganizationChartDTO;
import com.javastudio.tutorial.dto.PersonDTO;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ShiroSecured
@Named
@ViewScoped
public class OrganizationChartController extends ControllerBase<OrganizationChartDTO> implements Serializable {

    private static final long serialVersionUID = -4360806817248079581L;

    @Inject
    private Logger logger;

    @Inject
    BCryptPasswordService passwordService;

    @EJB
    OrganizationChartService service;

    public OrganizationChartController() {
        super(OrganizationChartDTO.class);
    }

    @Override
    public GeneralServiceApi<OrganizationChartDTO> getGeneralServiceApi() {
        return service;
    }

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    protected void afterLoad() {

    }

    public OrganizationChartDTO getOrganizationChart() {
        return super.entity;
    }

    public void setOrganizationChart(OrganizationChartDTO organizationChart) {
        super.entity = organizationChart;
    }
}
