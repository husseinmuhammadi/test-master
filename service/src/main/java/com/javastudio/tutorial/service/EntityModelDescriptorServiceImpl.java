package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.EntityModelDescriptorService;
import com.javastudio.tutorial.model.dao.EntityModelDescriptorDao;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.to.EntityModelDescriptor;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(EntityModelDescriptorService.class)
public class EntityModelDescriptorServiceImpl extends GeneralServiceImpl<EntityModelDescriptor, com.javastudio.tutorial.dto.EntityModelDescriptor> implements EntityModelDescriptorService {

    @Inject
    private Logger logger;

    @EJB
    EntityModelDescriptorDao dao;

    public EntityModelDescriptorServiceImpl() {
        super(EntityModelDescriptor.class, com.javastudio.tutorial.dto.EntityModelDescriptor.class);
    }

    @Override
    public GenericDao<EntityModelDescriptor> getGenericDao() {
        return dao;
    }
}
