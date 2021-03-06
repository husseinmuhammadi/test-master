package com.javastudio.lms.tutorial.web.controller.organizationchart;

import com.javastudio.lms.tutorial.web.annotation.ShiroSecured;
import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.OrganizationChartService;
import com.javastudio.tutorial.api.UserService;
import com.javastudio.tutorial.dto.OrganizationChart;
import com.javastudio.tutorial.jsf.component.UILookup;
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
public class OrganizationChartController extends ControllerBase<OrganizationChart> implements Serializable {

    private static final long serialVersionUID = 6309368835762788010L;

    @Inject
    private Logger logger;

    @EJB
    OrganizationChartService service;

    @EJB
    UserService userService;

    // region Fields

    List<SelectItem> selectUsers = new ArrayList<>();

    List<SelectItem> selectOrganizationCharts = new ArrayList<>();

    private UILookup uiLookupUser = new UILookup();

    Long userId;

    // endregion Fields

    // region Constructor
    public OrganizationChartController() {
        super(OrganizationChart.class);
    }
    // endregion Constructor

    @Override
    public GeneralServiceApi<OrganizationChart> getGeneralServiceApi() {
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
        if (uiLookupUser.getValue() != null && !"".equals(uiLookupUser.getValue())) {
            getOrganizationChart().setUser(userService.find(Long.valueOf(uiLookupUser.getValue().toString())));
        }
    }

    @Override
    protected void afterLoad() {

    }

    // region Getters & Setters

    public OrganizationChart getOrganizationChart() {
        return super.entity;
    }

    public void setOrganizationChart(OrganizationChart organizationChart) {
        super.entity = organizationChart;
    }

    public List<SelectItem> getSelectUsers() {
        return selectUsers;
    }

    public void setSelectUsers(List<SelectItem> selectUsers) {
        this.selectUsers = selectUsers;
    }

    public List<SelectItem> getSelectOrganizationCharts() {
        return selectOrganizationCharts;
    }

    public void setSelectOrganizationCharts(List<SelectItem> selectOrganizationCharts) {
        this.selectOrganizationCharts = selectOrganizationCharts;
    }

    public UILookup getUiLookupUser() {
        return uiLookupUser;
    }

    public void setUiLookupUser(UILookup uiLookupUser) {
        this.uiLookupUser = uiLookupUser;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // region Getters & Setters


}
