package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.model.to.Task;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TaskDao extends GenericDao<Task> {

    public TaskDao() {
        super(Task.class);
    }

    @Override
    public List<Task> findAll() {
        return createNamedQuery(Task.FIND_ALL).getResultList();
    }
}
