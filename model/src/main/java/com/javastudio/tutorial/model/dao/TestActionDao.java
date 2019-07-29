package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.TestAction;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TestActionDao extends GenericDao<TestAction> {

    public TestActionDao() {
        super(TestAction.class);
    }

    @Override
    public List<TestAction> findAll() {
        return createNamedQuery(TestAction.FIND_ALL).getResultList();
    }
}
