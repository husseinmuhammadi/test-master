package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.OrganizationChart;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrganizationChartDao extends GenericDao<OrganizationChart> {

    public OrganizationChartDao() {
        super(OrganizationChart.class);
    }

    @Override
    public List<OrganizationChart> findAll() {
        return createNamedQuery(OrganizationChart.FIND_ALL).getResultList();
    }
}
