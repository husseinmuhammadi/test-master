package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.Role;

import javax.ejb.Stateless;
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
