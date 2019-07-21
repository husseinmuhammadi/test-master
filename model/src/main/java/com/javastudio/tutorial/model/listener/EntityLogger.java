package com.javastudio.tutorial.model.listener;

import com.javastudio.tutorial.model.base.EntityBase;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.persistence.*;

public class EntityLogger {

    @Inject
    Logger logger;

    @PrePersist
    public void methodInvokedBeforePersist(EntityBase entity) {
        logger.info("Persisting " + entity.getClass().getSimpleName() + " with id = " + entity.getId());
    }

    @PostPersist
    public void methodInvokedAfterPersist(EntityBase entity) {
        logger.info("Persisted " + entity.getClass().getSimpleName() + " with id = " + entity.getId());
    }

    @PreUpdate
    public void methodInvokedBeforeUpdate(EntityBase entity) {
        logger.info("Updating " + entity.getClass().getSimpleName() + " with id = " + entity.getId());
    }

    @PostUpdate
    public void methodInvokedAfterUpdate(EntityBase entity) {
        logger.info("Updated " + entity.getClass().getSimpleName() + " with id = " + entity.getId());
    }

    @PreRemove
    private void methodInvokedBeforeRemove(EntityBase entity) {
        logger.info("Removing " + entity.getClass().getSimpleName() + " with id = " + entity.getId());
    }

    @PostRemove
    public void methodInvokedAfterRemove(EntityBase entity) {
        logger.info("Removed " + entity.getClass().getSimpleName() + " with id = " + entity.getId());
    }
}
