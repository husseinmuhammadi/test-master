package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.User;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

@Stateless
public class UserDao extends GenericDao<User> {

    @Inject
    private Logger logger;

    public UserDao() {
        super(User.class);
    }

    @Override
    public List<User> findAll() {
        return createNamedQuery(User.FIND_ALL).setFirstResult(0).setMaxResults(5).getResultList();
    }

    public User findByUsername(@NotNull String username) {
        logger.info("Find user by username ...");
        TypedQuery<User> userTypedQuery = createNamedQuery(User.FIND_BY_USERNAME, QueryParameterUtil.with("username", username).parameters());
        try {
            return userTypedQuery.getSingleResult();
        } catch (NoResultException e) {
            logger.warn("UserService : No user found for [" + username + "] : " + e);
            return null;
        }
    }

    public User findByEmail(@NotNull String username) {
        return null;
    }
}
