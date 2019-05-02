package com.javastudio.tutorial.model.base;

import javax.persistence.Embeddable;

@Embeddable
public abstract class EntityState {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
