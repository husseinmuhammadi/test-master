package com.javastudio.tutorial.dto;

public class Permission extends DTOBase {

    public Permission() {
    }

    public Permission(String name) {
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
