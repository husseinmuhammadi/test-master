package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.model.base.EntityState;
import com.javastudio.tutorial.model.base.StatedEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PRODUCT_SEQ")
public class Product extends EntityBase implements StatedEntity {

    private String title;

    @Embedded
    EntityState state;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public EntityState getState() {
        return state;
    }

    @Override
    public void setState(EntityState state) {
        this.state = state;
    }
}
