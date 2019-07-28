package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.Issue;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class IssueDao extends GenericDao<Issue> {

    public IssueDao() {
        super(Issue.class);
    }

    @Override
    public List<Issue> findAll() {
        return createNamedQuery(Issue.FIND_ALL).getResultList();
    }
}
