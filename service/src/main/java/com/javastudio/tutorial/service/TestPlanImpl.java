package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.TestPlanService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.IssueDao;
import com.javastudio.tutorial.model.dao.TestPlanDao;
import com.javastudio.tutorial.model.to.Issue;
import com.javastudio.tutorial.model.to.TestPlan;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Local(TestPlanService.class)
public class TestPlanImpl extends GeneralServiceImpl<TestPlan, com.javastudio.tutorial.dto.TestPlan> {

    @Inject
    private Logger logger;

    @EJB
    TestPlanDao dao;

    @EJB
    IssueDao issueDao;

    public TestPlanImpl() {
        super(TestPlan.class, com.javastudio.tutorial.dto.TestPlan.class);
    }

    @Override
    public GenericDao<TestPlan> getGenericDao() {
        return dao;
    }

    public List<com.javastudio.tutorial.dto.TestPlan> findByIssueNo(com.javastudio.tutorial.dto.Issue issue) {
        logger.info("Find test plans by issue ...");
        return dao.findByIssueNo(issueDao.findById(issue.getId())).stream().map(testPlan -> mapper.map(testPlan, com.javastudio.tutorial.dto.TestPlan.class)).collect(Collectors.toList());
    }
}
