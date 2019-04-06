package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.model.base.EntityBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Dependent
public abstract class GenericDao<T extends EntityBase> {

    @Inject
    private Logger logger;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Inject
    private EntityManager entityManager;

    private final Class<T> entityBeanType;

    public GenericDao(Class<T> entityBeanType) {
        this.entityBeanType = entityBeanType;
    }

    public T create(T t) {
        logger.info("GenericDao --> create");
        entityManager.persist(t);
        return t;
    }

    public void remove(T t) {
        if (entityManager.contains(t))
            entityManager.remove(t);
        else
            entityManager.remove(entityManager.getReference(entityBeanType, t.getId()));
    }

    public T update(T t) {
        if (t.getId() != null) {
            if (entityManager.contains(t)) {
                return t;
            } else {
                return entityManager.merge(t);
            }
        }
        return null;
    }

    public T findById(Long id) {
        return entityManager.find(entityBeanType, id);
    }

    // TODO: Add method body
    public abstract List<T> findAll();/* {
        return createNamedQuery(T.FIND_ALL).getResultList();
    }*/

    public TypedQuery<T> createNamedQuery(String queryName) {
        logger.info(MessageFormat.format("Create named query: {0}", queryName));
        Arrays.stream(Thread.currentThread().getStackTrace()).forEach(i -> logger.info(i.getClassName() + ":" + i.getMethodName()));
        return entityManager.createNamedQuery(queryName, entityBeanType);
    }

    public TypedQuery<T> createNamedQuery(String namedQueryName, Map<String, Object> parameters) {
        return createNamedQuery(namedQueryName, parameters, 0);
    }

    public TypedQuery<T> createNamedQuery(String namedQueryName, Map<String, Object> parameters, int limitResult) {
        Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
        TypedQuery typedQuery = createNamedQuery(namedQueryName);
        if (limitResult > 0) {
            typedQuery.setMaxResults(limitResult);
        }
        for (Map.Entry<String, Object> entry : rawParameters) {
            typedQuery.setParameter(entry.getKey(), entry.getValue());
        }
        return typedQuery;
    }


}
