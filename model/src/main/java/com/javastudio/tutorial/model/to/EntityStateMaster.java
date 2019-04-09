package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "ENTITY_STATE_MASTER")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "ENTITY_STATE_MASTER_SEQ")
@NamedQueries({
        @NamedQuery(name = EntityStateMaster.FIND_ALL, query = "select t from EntityStateMaster t"),
})
public class EntityStateMaster extends EntityBase {

    public static final String FIND_ALL = "EntityStateMaster.findAll";

    @Column(name = "ENTITY_NAME", length = 100)
    private String entityName;

    @Column(name = "STATE_NAME", length = 100)
    private String stateName;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
