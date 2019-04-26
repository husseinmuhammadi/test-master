package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.TaskService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.TaskDao;
import com.javastudio.tutorial.dto.TaskDTO;
import com.javastudio.tutorial.model.to.Task;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(TaskService.class)
public class TaskServiceImpl extends GeneralServiceImpl<Task, TaskDTO> implements TaskService {

    @Inject
    private Logger logger;

    @EJB
    TaskDao dao;

    public TaskServiceImpl() {
        super(Task.class, TaskDTO.class);
    }

    @Override
    public GenericDao<Task> getGenericDao() {
        return dao;
    }
}
