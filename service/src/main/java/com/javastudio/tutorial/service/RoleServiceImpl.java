package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.RoleService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.RoleDao;
import com.javastudio.tutorial.dto.RoleDTO;
import com.javastudio.tutorial.model.to.Role;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local({RoleService.class})
public class RoleServiceImpl extends GeneralServiceImpl<Role, RoleDTO> implements RoleService {

    @EJB
    RoleDao dao;

    public RoleServiceImpl() {
        super(Role.class, RoleDTO.class);
    }

    @Override
    public GenericDao<Role> getGenericDao() {
        return dao;
    }
}
