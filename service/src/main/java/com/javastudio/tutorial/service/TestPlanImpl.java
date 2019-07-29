package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.IssueService;
import com.javastudio.tutorial.api.TestPlanService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.IssueDao;
import com.javastudio.tutorial.model.dao.TestPlanDao;
import com.javastudio.tutorial.model.to.Issue;
import com.javastudio.tutorial.model.to.TestPlan;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(TestPlanService.class)
public class TestPlanImpl extends GeneralServiceImpl<TestPlan, com.javastudio.tutorial.dto.TestPlan> {

    @EJB
    TestPlanDao dao;

    public TestPlanImpl() {
        super(TestPlan.class, com.javastudio.tutorial.dto.TestPlan.class);
    }

    @Override
    public GenericDao<TestPlan> getGenericDao() {
        return dao;
    }
}
