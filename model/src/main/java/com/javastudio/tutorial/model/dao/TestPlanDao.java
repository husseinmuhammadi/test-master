package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.Issue;
import com.javastudio.tutorial.model.to.TestPlan;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
}
