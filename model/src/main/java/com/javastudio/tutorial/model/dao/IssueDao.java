package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.Issue;
import org.slf4j.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class IssueDao extends GenericDao<Issue> {

    @Inject
    private Logger logger;

    public IssueDao() {
        super(Issue.class);
    }

    @Override
    public List<Issue> findAll() {
        return createNamedQuery(Issue.FIND_ALL).getResultList();
    }

    public Issue findByIssueNo(Long issueNo) {
        logger.info("Find user by username ...");
        TypedQuery<Issue> userTypedQuery = createNamedQuery(Issue.FIND_BY_ISSUE_NO, QueryParameterUtil.with("issueNo", issueNo).parameters());
        try {
            return userTypedQuery.getSingleResult();
        } catch (NoResultException e) {
            logger.warn("UserService : No issue found for [" + issueNo + "] : " + e);
            return null;
        }

    }
}
