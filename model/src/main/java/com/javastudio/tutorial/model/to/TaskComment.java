package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.model.listener.AuditListener;

import javax.persistence.*;

@Entity
@Table(name = "TASK_COMMENT")
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "TASK_COMMENT_SEQ")
public class TaskComment extends EntityBase {

    @ManyToOne
    Task task;

    private String review;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
