package com.javastudio.tutorial.model.listener;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

public class EntityLogger {

    @PrePersist
    public void methodInvokedBeforePersist(EntityBase entity) {
        System.out.println("persisting employee with id = " + entity.getId());
    }

    @PostPersist
    public void methodInvokedAfterPersist(EntityBase entity) {
        System.out.println("Persisted employee with id = " + entity.getId());
    }

    @PreUpdate
    public void methodInvokedBeforeUpdate(EntityBase entity) {
        System.out.println("Updating employee with id = " + entity.getId());
    }

    @PostUpdate
    public void methodInvokedAfterUpdate(EntityBase entity) {
        System.out.println("Updated employee with id = " + entity.getId());
    }

    @PreRemove
    private void methodInvokedBeforeRemove(EntityBase entity) {
        System.out.println("Removing employee with id = " + entity.getId());
    }

    @PostRemove
    public void methodInvokedAfterRemove(EntityBase entity) {
        System.out.println("Removed employee with id = " + entity.getId());
    }
}
