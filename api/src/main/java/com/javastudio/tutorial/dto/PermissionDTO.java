package com.javastudio.tutorial.dto;

public class PermissionDTO extends DTOBase {

    public PermissionDTO() {
    }

    public PermissionDTO(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
