package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.PermissionService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.PermissionDao;

import com.javastudio.tutorial.model.to.Permission;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(PermissionService.class)
public class PermissionServiceImpl extends GeneralServiceImpl<Permission, com.javastudio.tutorial.dto.Permission> implements PermissionService {

    @Inject
    private Logger logger;

    @EJB
    PermissionDao dao;

    public PermissionServiceImpl() {
        super(Permission.class, com.javastudio.tutorial.dto.Permission.class);
    }

    @Override
    public GenericDao<Permission> getGenericDao() {
        return dao;
    }
}
