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

    @Column(name = "ACTIVITY_NAME")
    private String activityName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ENTITY_INDICATOR", referencedColumnName = "ENTITY_INDICATOR", insertable = false, updatable = false),
            @JoinColumn(name = "CURRENT_STATE", referencedColumnName = "STATE_NAME", insertable = false, updatable = false),
    })
    private EntityStateMaster currentState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ENTITY_INDICATOR", referencedColumnName = "ENTITY_INDICATOR", insertable = false, updatable = false),
            @JoinColumn(name = "NEXT_STATE", referencedColumnName = "STATE_NAME", insertable = false, updatable = false),
    })
    private EntityStateMaster nextState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERMISSION", referencedColumnName = "PERMISSION")
    private Permission permission;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public EntityStateMaster getCurrentState() {
        return currentState;
    }

    public void setCurrentState(EntityStateMaster currentState) {
        this.currentState = currentState;
    }

    public EntityStateMaster getNextState() {
        return nextState;
    }

    public void setNextState(EntityStateMaster nextState) {
        this.nextState = nextState;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

}
