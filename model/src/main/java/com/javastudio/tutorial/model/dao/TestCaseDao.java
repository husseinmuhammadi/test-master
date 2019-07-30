package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.TestCase;
import org.slf4j.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TestCaseDao extends GenericDao<TestCase> {

    @Inject
    private Logger logger;

    public TestCaseDao() {
        super(TestCase.class);
    }

    @Override
    public List<TestCase> findAll() {
        logger.info("Test case find all ...");
        return createNamedQuery(TestCase.FIND_ALL).getResultList();
    }
}
