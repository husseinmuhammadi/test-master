package com.javastudio.tutorial.dto;

import com.javastudio.tutorial.type.EntityIndicator;

public class StateDTO extends DTOBase {

    public StateDTO() {
    }

    public StateDTO(EntityIndicator entityIndicator, String stateName) {
        this.entityIndicator = entityIndicator;
        this.stateName = stateName;
    }

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
