package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.OrganizationChart;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
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

    public OrganizationChart findByOrganizationDescriptor(String corporateId, String title, String username) {
        TypedQuery<OrganizationChart> namedQuery = createNamedQuery(OrganizationChart.FIND_BY_ORGANIZATION_DESCRIPTOR, QueryParameterUtil.with("corporateId", corporateId).and("title", title).and("username", username).parameters());
        return namedQuery.getSingleResult();
    }
}
