package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.OrganizationChartService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.OrganizationChartDao;
import com.javastudio.tutorial.model.to.OrganizationChart;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(OrganizationChartService.class)
public class OrganizationChartServiceImpl extends GeneralServiceImpl<OrganizationChart, com.javastudio.tutorial.dto.OrganizationChart> implements OrganizationChartService {

    @Inject
    private Logger logger;

    @EJB
    OrganizationChartDao dao;

    public OrganizationChartServiceImpl() {
        super(OrganizationChart.class, com.javastudio.tutorial.dto.OrganizationChart.class);
    }

    @Override
    public GenericDao<OrganizationChart> getGenericDao() {
        return dao;
    }

    @Override
    public com.javastudio.tutorial.dto.OrganizationChart findByOrganizationDescriptor(String corporateId, String title, String username) {
        return dto(dao.findByOrganizationDescriptor(corporateId, title, username));
    }
}
