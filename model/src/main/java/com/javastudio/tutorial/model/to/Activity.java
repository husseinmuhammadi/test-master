package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.model.converter.EntityIndicatorConverter;
import com.javastudio.tutorial.model.type.EntityIndicator;

import javax.persistence.*;

@Entity
@Table(name = "ACTIVITY_MASTER")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "ACTIVITY_MASTER_SEQ")
@NamedQueries({
        @NamedQuery(name = Activity.FIND_ALL, query = "select t from Activity t"),
})
public class Activity extends EntityBase {

    // region Constant
    public static final String FIND_ALL = "Activity.findAll";

    public static final String ACTIVITY_NAME = "ACTIVITY_NAME";
    public static final String CURRENT_STATE = "CURRENT_STATE";
    public static final String NEXT_STATE = "NEXT_STATE";
    public static final String PERMISSION_NAME = "PERMISSION_NAME";
    public static final String ENTITY_INDICATOR = "ENTITY_INDICATOR";
    // endregion Constant

    @Column(name = ENTITY_INDICATOR, length = 100)
    @Convert(converter = EntityIndicatorConverter.class)
    EntityIndicator entityIndicator;

    @Column(name = ACTIVITY_NAME)
    private String name;

    @Column(name = CURRENT_STATE)
    private String currentState;

    @Column(name = NEXT_STATE)
    private String nextState;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = PERMISSION_NAME, referencedColumnName = Permission.NAME)
    private Permission permission;

    public String getName() {
        return name;
    }

    public void setName(String activityName) {
        this.name = activityName;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
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

    public EntityIndicator getEntityIndicator() {
        return entityIndicator;
    }

    public void setEntityIndicator(EntityIndicator entityIndicator) {
        this.entityIndicator = entityIndicator;
    }
}
