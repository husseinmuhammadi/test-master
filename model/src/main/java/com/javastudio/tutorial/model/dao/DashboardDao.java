package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.base.StateTracker;
import com.javastudio.tutorial.model.to.Dashboard;
import org.slf4j.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class DashboardDao extends GenericDao<Dashboard> {

    @Inject
    Logger logger;

    public DashboardDao() {
        super(Dashboard.class);
    }

    @Override
    public List<Dashboard> findAll() {
        return createNamedQuery(Dashboard.FIND_ALL).getResultList();
    }

    public List<Dashboard> findByEntity(StateTracker entity) {
        TypedQuery<Dashboard> namedQuery = createNamedQuery(Dashboard.FIND_BY_ENTITY, QueryParameterUtil
                .with("entity", entity)
                .and("state", "E").parameters()
        );
        return namedQuery.getResultList();
    }

    public Dashboard findByEntityState(StateTracker entity) {
        try {
            TypedQuery<Dashboard> namedQuery = createNamedQuery(Dashboard.FIND_BY_ENTITY, QueryParameterUtil
                    .with("entity", entity)
                    .and("entityState", entity.getState())
                    .and("state", "E").parameters()
            );
            return namedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
