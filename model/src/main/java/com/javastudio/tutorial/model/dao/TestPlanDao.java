package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.Issue;
import com.javastudio.tutorial.model.to.OrganizationChart;
import com.javastudio.tutorial.model.to.TestPlan;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class TestPlanDao extends GenericDao<TestPlan> {

    public TestPlanDao() {
        super(TestPlan.class);
    }

    @Override
    public List<TestPlan> findAll() {
        return createNamedQuery(TestPlan.FIND_ALL).getResultList();
    }

    public List<TestPlan> findByIssueNo(Issue issue) {
        TypedQuery<TestPlan> namedQuery = createNamedQuery(TestPlan.FIND_BY_ISSUE, QueryParameterUtil.with("issue", issue).parameters());
        return namedQuery.getResultList();
    }
}
