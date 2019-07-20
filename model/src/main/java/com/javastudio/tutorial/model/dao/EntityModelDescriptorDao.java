package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.EntityModelDescriptor;
import com.javastudio.tutorial.model.to.Person;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class EntityModelDescriptorDao extends GenericDao<EntityModelDescriptor> {

    public EntityModelDescriptorDao() {
        super(EntityModelDescriptor.class);
    }

    @Override
    public List<EntityModelDescriptor> findAll() {
        return createNamedQuery(EntityModelDescriptor.FIND_ALL).getResultList();
    }
}
