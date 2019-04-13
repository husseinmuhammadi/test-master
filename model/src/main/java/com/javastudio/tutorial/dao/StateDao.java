package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.model.to.State;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class StateDao extends GenericDao<State> {

    public StateDao() {
        super(State.class);
    }

    @Override
    public List<State> findAll() {
        return createNamedQuery(State.FIND_ALL).getResultList();
    }
}
