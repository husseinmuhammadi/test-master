package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "ACTIVITY_MASTER")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "ACTIVITY_MASTER_SEQ")
@NamedQueries({
        @NamedQuery(name = Activity.FIND_ALL, query = "select t from Activity t"),
})
public class Activity extends EntityBase {

    public static final String FIND_ALL = "Activity.findAll";

    public static final String ACTIVITY_NAME = "ACTIVITY_NAME";

    @Column(name = ACTIVITY_NAME)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ENTITY_INDICATOR", referencedColumnName = "ENTITY_INDICATOR", insertable = false, updatable = false),
            @JoinColumn(name = "CURRENT_STATE", referencedColumnName = "STATE_NAME", insertable = false, updatable = false),
    })
    private State currentState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ENTITY_INDICATOR", referencedColumnName = "ENTITY_INDICATOR", insertable = false, updatable = false),
            @JoinColumn(name = "NEXT_STATE", referencedColumnName = "STATE_NAME", insertable = false, updatable = false),
    })
    private State nextState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERMISSION_NAME", referencedColumnName = Permission.DB_COLUMN_NAME)
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

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }
}
