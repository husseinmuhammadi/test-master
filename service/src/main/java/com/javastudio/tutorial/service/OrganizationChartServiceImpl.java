package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.OrganizationChartService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.OrganizationChartDao;
import com.javastudio.tutorial.dto.OrganizationChartDTO;
import com.javastudio.tutorial.model.to.OrganizationChart;
import com.sun.corba.se.impl.orb.ParserTable;
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

    @Override
    public OrganizationChartDTO findByOrganizationDescriptor(String corporateId, String title, String username) {
        return dto(dao.findByOrganizationDescriptor(corporateId, title, username));
    }
}
