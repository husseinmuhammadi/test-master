package com.javastudio.tutorial.dto;

import com.javastudio.tutorial.type.EntityIndicator;

public class StateDTO extends DTOBase {

    private EntityIndicator entityIndicator;

    private String stateName;

    public EntityIndicator getEntityIndicator() {
        return entityIndicator;
    }

    public void setEntityIndicator(EntityIndicator entityIndicator) {
        this.entityIndicator = entityIndicator;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
