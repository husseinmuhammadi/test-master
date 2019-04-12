package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "Task")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "Task_SEQ")
@NamedQueries({
        @NamedQuery(name = Task.FIND_ALL, query = "select t from Task t"),
})
public class Task extends EntityBase {

    public static final String FIND_ALL = "Task.findAll";

    @Column(name = "TASK_DESCRIPTION", length = 400)
    String taskDescription;

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
