package com.javastudio.tutorial.dto;

public class ActivityDTO extends DTOBase {

    private String entity;

    private String name;

    private String currentState;

    private String nextState;

    private PermissionDTO permission;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionDTO getPermission() {
        return permission;
    }

    public void setPermission(PermissionDTO permission) {
        this.permission = permission;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
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
}
