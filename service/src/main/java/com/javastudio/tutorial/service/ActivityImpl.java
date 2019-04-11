package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.ActivityService;
import com.javastudio.tutorial.api.PersonService;
import com.javastudio.tutorial.dao.ActivityDao;
import com.javastudio.tutorial.dao.GenericDao;
import com.javastudio.tutorial.dto.ActivityDTO;
import com.javastudio.tutorial.model.to.Activity;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(ActivityService.class)
public class ActivityImpl extends GeneralServiceImpl<Activity, ActivityDTO> implements ActivityService {

    @Inject
    private Logger logger;

    @EJB
    ActivityDao dao;

    public ActivityImpl() {
        super(Activity.class, ActivityDTO.class);
    }

    @Override
    public GenericDao<Activity> getGenericDao() {
        return dao;
    }
}
