package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.Permission;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PermissionDao extends GenericDao<Permission> {

    public PermissionDao() {
        super(Permission.class);
    }

    @Override
    public List<Permission> findAll() {
        return createNamedQuery(Permission.FIND_ALL).getResultList();
    }
}
