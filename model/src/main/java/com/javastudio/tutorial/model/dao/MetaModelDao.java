package com.javastudio.tutorial.model.dao;

import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

@Stateless
public class MetaModelDao {

    @Inject
    private Logger logger;

    @Inject
    EntityManager entityManager;

    public void listAllEntities() {
        for (EntityType<?> entity : entityManager.getMetamodel().getEntities()) {
            final String className = entity.getName();
            logger.debug("Trying select * from: " + className);
            Query q = entityManager.createQuery("from " + className + " c");
            q.getResultList().iterator();
            logger.info("ok: " + className);
        }
    }

    public Set<EntityType<?>> getMetamodelEntityTypes() {
        return entityManager.getMetamodel().getEntities();
    }
}
