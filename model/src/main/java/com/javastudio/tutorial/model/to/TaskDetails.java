package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.model.listener.AuditListener;

import javax.persistence.*;

@Entity
@Table(name = "TASK_DETAILS")
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "TASK_DETAILS_SEQ")
public class TaskDetails extends EntityBase {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    Task task;

    @Lob
    private byte[] image;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
