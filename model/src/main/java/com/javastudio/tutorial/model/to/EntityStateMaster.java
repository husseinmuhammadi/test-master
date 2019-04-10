package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.model.converter.EntityIndicatorConverter;
import com.javastudio.tutorial.type.EntityIndicator;

import javax.persistence.*;

@Entity
@Table(name = "ENTITY_STATE_MASTER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ENTITY_INDICATOR", "STATE_NAME"})
})
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "ENTITY_STATE_MASTER_SEQ")
@NamedQueries({
        @NamedQuery(name = EntityStateMaster.FIND_ALL, query = "select t from EntityStateMaster t"),
})
public class EntityStateMaster extends EntityBase {

    public static final String FIND_ALL = "EntityStateMaster.findAll";

    @Column(name = "ENTITY_INDICATOR", length = 100)
    @Convert(converter = EntityIndicatorConverter.class)
    private EntityIndicator entityIndicator;

    @Column(name = "STATE_NAME", length = 100)
    private String stateName;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public EntityIndicator getEntityIndicator() {
        return entityIndicator;
    }

    public void setEntityIndicator(EntityIndicator entityIndicator) {
        this.entityIndicator = entityIndicator;
    }
}
