package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.OrganizationChartService;
import com.javastudio.tutorial.dao.GenericDao;
import com.javastudio.tutorial.dao.OrganizationChartDao;
import com.javastudio.tutorial.dto.OrganizationChartDTO;
import com.javastudio.tutorial.model.to.OrganizationChart;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(OrganizationChartService.class)
public class OrganizationChartServiceImpl extends GeneralServiceImpl<OrganizationChart, OrganizationChartDTO> implements OrganizationChartService {

    @Inject
    private Logger logger;

    @EJB
    OrganizationChartDao dao;

    public OrganizationChartServiceImpl() {
        super(OrganizationChart.class, OrganizationChartDTO.class);
    }

    @Override
    public GenericDao<OrganizationChart> getGenericDao() {
        return dao;
    }
}
