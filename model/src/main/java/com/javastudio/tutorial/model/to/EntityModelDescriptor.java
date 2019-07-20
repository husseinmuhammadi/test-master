package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.model.base.HasState;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;

@Entity
@Table(name = "ENTITY_MODEL_DESCRIPTOR")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "ENTITY_MODEL_DESCRIPTOR_SEQ")
@NamedQueries({
        @NamedQuery(name = EntityModelDescriptor.FIND_ALL, query = "select t from EntityModelDescriptor t where t.deleted = false ")
})
public class EntityModelDescriptor extends EntityBase {

    public static final String FIND_ALL = "EntityModelDescriptor.findAll";

    String entityMetaValue;

    String currentState;

    String nextState;

    String requiredPermission;

    public String getEntityMetaValue() {
        return entityMetaValue;
    }

    public void setEntityMetaValue(String entityMetaValue) {
        this.entityMetaValue = entityMetaValue;
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

    public String getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(String requiredPermission) {
        this.requiredPermission = requiredPermission;
    }
}
