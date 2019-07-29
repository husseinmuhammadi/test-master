package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.TestActionService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.TestActionDao;
import com.javastudio.tutorial.model.to.TestAction;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(TestActionService.class)
public class TestActionImpl extends GeneralServiceImpl<TestAction, com.javastudio.tutorial.dto.TestAction> {

    @EJB
    TestActionDao dao;

    public TestActionImpl() {
        super(TestAction.class, com.javastudio.tutorial.dto.TestAction.class);
    }

    @Override
    public GenericDao<TestAction> getGenericDao() {
        return dao;
    }
}
