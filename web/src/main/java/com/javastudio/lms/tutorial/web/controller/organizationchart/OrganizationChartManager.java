package com.javastudio.lms.tutorial.web.controller.organizationchart;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.OrganizationChartService;
import com.javastudio.tutorial.dto.OrganizationChartDTO;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class OrganizationChartManager extends ManagerBase<OrganizationChartDTO> implements Serializable {

    private static final long serialVersionUID = -9051371651827827993L;

    @Inject
    private Logger logger;

    @EJB
    OrganizationChartService service;

    public OrganizationChartManager() {
        super(OrganizationChartDTO.class);
    }

    @Override
    protected void onLoad() {
        logger.info("");
    }

    @Override
    public GeneralServiceApi<OrganizationChartDTO> getGeneralServiceApi() {
        return service;
    }

    public List<OrganizationChartDTO> getOrganizationCharts() {
        return entityList;
    }
}
