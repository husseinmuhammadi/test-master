package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.TestCaseService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.TestCaseDao;
import com.javastudio.tutorial.model.to.TestCase;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(TestCaseService.class)
public class TestCaseServiceImpl extends GeneralServiceImpl<TestCase, com.javastudio.tutorial.dto.TestCase> {

    @EJB
    TestCaseDao dao;

    public TestCaseServiceImpl() {
        super(TestCase.class, com.javastudio.tutorial.dto.TestCase.class);
    }

    @Override
    public GenericDao<TestCase> getGenericDao() {
        return dao;
    }
}
