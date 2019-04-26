package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.Activity;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ActivityDao extends GenericDao<Activity> {

    public ActivityDao() {
        super(Activity.class);
    }

    @Override
    public List<Activity> findAll() {
        return createNamedQuery(Activity.FIND_ALL).getResultList();
    }
}
