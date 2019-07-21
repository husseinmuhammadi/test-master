package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.base.EntityBase;
import org.slf4j.Logger;

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

    @Inject
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

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

    // TODO: Add method body https://github.com/jaxio/jpa-query-by-example/blob/master/src/main/java/com/jaxio/jpa/querybyexample/GenericRepository.java
    public abstract List<T> findAll();

    public TypedQuery<T> createNamedQuery(String queryName) {
        logger.debug(MessageFormat.format("Create named query: {0}", queryName));
        Arrays.stream(Thread.currentThread().getStackTrace()).forEach(i -> logger.debug(i.getClassName() + ":" + i.getMethodName()));
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
