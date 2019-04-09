package com.javastudio.tutorial.model.to;

import javax.persistence.*;

@Entity
@Table(name = "ENTITY_ACTIVITY_MASTER")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "ENTITY_ACTIVITY_MASTER_SEQ")
@NamedQueries({
        @NamedQuery(name = EntityActivityMaster.FIND_ALL, query = "select t from EntityActivityMaster t"),
})
public class EntityActivityMaster {

    public static final String FIND_ALL = "EntityActivityMaster.findAll";

    @Column(name = "ENTITY_NAME")
    private String entityName;

    @Column(name = "ACTIVITY_NAME")
    private String activityName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENT_STATE_ID")
    private EntityStateMaster currentState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NEXT_STATE_ID")
    private EntityStateMaster nextState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERMISSION", referencedColumnName = "PERMISSION")
    private Permission permission;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

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
