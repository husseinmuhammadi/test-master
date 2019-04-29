package com.javastudio.tutorial.model.type;

import com.javastudio.tutorial.model.to.Person;

import java.util.HashMap;
import java.util.Map;

public enum EntityIndicator {
    Person(Person.class, "P"),;

    private static final Map<String, EntityIndicator> entityIndicatorMap = new HashMap<>();
    private static final Map<Class<?>, EntityIndicator> entityTypeMap = new HashMap<>();

    static {
        for (EntityIndicator entityIndicator : values()) {
            entityIndicatorMap.put(entityIndicator.getCode(), entityIndicator);
            entityTypeMap.put(entityIndicator.getType(), entityIndicator);
        }
    }

    private final String code;
    private final Class<?> type;

    // region Constructor
    EntityIndicator(Class<?> type, String code) {
        this.type = type;
        this.code = code;
    }
    // endregion Constructor

    public static EntityIndicator getInstance(String value) {
        return entityIndicatorMap.get(value);
    }

    public static EntityIndicator getInstance(Class<?> type) {
        return entityTypeMap.get(type);
    }

    // region Getters & Setters
    public String getCode() {
        return code;
    }

    public Class<?> getType() {
        return type;
    }
    // endregion Getters & Setters

}
