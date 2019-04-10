package com.javastudio.tutorial.type;

public enum EntityIndicator{

    Person("P"),;

    private final String code;

    EntityIndicator(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public EntityIndicator getInstance(String value){
        return Person;
    }
}
