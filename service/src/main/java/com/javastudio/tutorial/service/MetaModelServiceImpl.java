package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.MetaModelService;
import com.javastudio.tutorial.model.dao.MetaModelDao;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

@Stateless
@Local(MetaModelService.class)
public class MetaModelServiceImpl implements MetaModelService {

    @EJB
    MetaModelDao dao;

    public Set<EntityType<?>> getMetamodelEntityTypes(){
        return dao.getMetamodelEntityTypes();
    }
}
