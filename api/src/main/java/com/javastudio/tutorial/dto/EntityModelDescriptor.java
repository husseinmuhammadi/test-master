package com.javastudio.tutorial.dto;

public class EntityModelDescriptor extends DTOBase {

    String entityMetaValue;

    String currentState;

    String nextState;

    String requiredPermission;

    public String getEntityMetaValue() {
        return entityMetaValue;
    }

    public void setEntityMetaValue(String entityMetaValue) {
        this.entityMetaValue = entityMetaValue;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public String getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(String requiredPermission) {
        this.requiredPermission = requiredPermission;
    }
}
