package com.javastudio.tutorial.dto;

public class ActivityDTO extends DTOBase {

    private String name;

//    private StateDTO currentState;
//
//    private StateDTO nextState;

    private PermissionDTO permission;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public StateDTO getCurrentState() {
//        return currentState;
//    }

//    public void setCurrentState(StateDTO currentState) {
//        this.currentState = currentState;
//    }

//    public StateDTO getNextState() {
//        return nextState;
//    }

//    public void setNextState(StateDTO nextState) {
//        this.nextState = nextState;
//    }

    public PermissionDTO getPermission() {
        return permission;
    }

    public void setPermission(PermissionDTO permission) {
        this.permission = permission;
    }
}
