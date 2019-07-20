package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.EntityModelDescriptorService;
import com.javastudio.tutorial.api.PersonService;
import com.javastudio.tutorial.dto.EntityModelDescriptorDTO;
import com.javastudio.tutorial.dto.PersonDTO;
import com.javastudio.tutorial.model.dao.EntityModelDescriptorDao;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.PersonDao;
import com.javastudio.tutorial.model.to.EntityModelDescriptor;
import com.javastudio.tutorial.model.to.Person;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(EntityModelDescriptorService.class)
public class EntityModelDescriptorServiceImpl extends GeneralServiceImpl<EntityModelDescriptor, EntityModelDescriptorDTO> implements EntityModelDescriptorService {

    @Inject
    private Logger logger;

    @EJB
    EntityModelDescriptorDao dao;

    public EntityModelDescriptorServiceImpl() {
        super(EntityModelDescriptor.class, EntityModelDescriptorDTO.class);
    }

    @Override
    public GenericDao<EntityModelDescriptor> getGenericDao() {
        return dao;
    }
}
