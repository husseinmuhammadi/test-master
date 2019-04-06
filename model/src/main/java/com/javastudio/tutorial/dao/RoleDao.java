package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.model.to.Role;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

@Stateless
public class RoleDao extends GenericDao<Role> {

//    @Inject
//    private Logger logger;

    public RoleDao() {
        super(Role.class);
    }

    @Override
    public List<Role> findAll() {
        return createNamedQuery(Role.FIND_ALL).getResultList();
    }
}
