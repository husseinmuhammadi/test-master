package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.Auditable;
import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.model.base.StateTracker;
import com.javastudio.tutorial.model.listener.AuditListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PRODUCT_SEQ")
@EntityListeners(AuditListener.class)
public class Product extends EntityBase implements Auditable, StateTracker {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
