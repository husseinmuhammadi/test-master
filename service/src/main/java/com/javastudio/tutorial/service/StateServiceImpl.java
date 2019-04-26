package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.StateService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.StateDao;
import com.javastudio.tutorial.dto.StateDTO;
import com.javastudio.tutorial.model.to.State;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(StateService.class)
public class StateServiceImpl extends GeneralServiceImpl<State, StateDTO> implements StateService {

    @Inject
    private Logger logger;

    @EJB
    StateDao dao;

    public StateServiceImpl() {
        super(State.class, StateDTO.class);
    }

    @Override
    public GenericDao<State> getGenericDao() {
        return dao;
    }
}
