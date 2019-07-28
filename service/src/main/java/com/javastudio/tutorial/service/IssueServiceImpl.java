package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.IssueService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.IssueDao;
import com.javastudio.tutorial.model.to.Issue;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(IssueService.class)
public class IssueServiceImpl extends GeneralServiceImpl<Issue, com.javastudio.tutorial.dto.Issue> {

    @EJB
    IssueDao dao;

    public IssueServiceImpl() {
        super(Issue.class, com.javastudio.tutorial.dto.Issue.class);
    }

    @Override
    public GenericDao<Issue> getGenericDao() {
        return dao;
    }
}
