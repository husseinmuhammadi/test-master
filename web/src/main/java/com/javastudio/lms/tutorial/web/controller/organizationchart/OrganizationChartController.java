package com.javastudio.lms.tutorial.web.controller.organizationchart;

import com.javastudio.lms.tutorial.web.annotation.ShiroSecured;
import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.OrganizationChartService;
import com.javastudio.tutorial.api.UserService;
import com.javastudio.tutorial.dto.OrganizationChartDTO;
import com.javastudio.tutorial.dto.UserDTO;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ShiroSecured
@Named
@ViewScoped
public class OrganizationChartController extends ControllerBase<OrganizationChartDTO> implements Serializable {

    private static final long serialVersionUID = -4360806817248079581L;

    @Inject
    private Logger logger;

    @EJB
    OrganizationChartService service;

    @EJB
    UserService userService;

    // region Fields

    List<SelectItem> selectUsers = new ArrayList<>();

    List<SelectItem> selectOrganizationCharts = new ArrayList<>();

    // endregion Fields

    // region Constructor
    public OrganizationChartController() {
        super(OrganizationChartDTO.class);
    }
    // endregion Constructor

    @Override
    public GeneralServiceApi<OrganizationChartDTO> getGeneralServiceApi() {
        return service;
    }

    @Override
    @PostConstruct
    protected void init() {
        super.init();
        userService.findAll().forEach(user -> selectUsers.add(new SelectItem(user, user.getUsername())));
        service.findAll().forEach(organizationChart -> {
            String corporateId = organizationChart.getCorporateId();
            String title = organizationChart.getTitle();
            String username = organizationChart.getUser() == null ? "reserved" : organizationChart.getUser().getUsername();
            String organizationDescriptor = String.format("%s:%s:%s", corporateId, title, username);
            selectOrganizationCharts.add(new SelectItem(organizationChart, organizationDescriptor));
        });
    }

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    protected void afterLoad() {

    }

    // region Getters & Setters

    public OrganizationChartDTO getOrganizationChart() {
        return super.entity;
    }

    public void setOrganizationChart(OrganizationChartDTO organizationChart) {
        super.entity = organizationChart;
    }

    public List<SelectItem> getSelectUsers() {
        return selectUsers;
    }

    public void setSelectUsers(List<SelectItem> selectUsers) {
        this.selectUsers = selectUsers;
    }

    // region Getters & Setters
}
