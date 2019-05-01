package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.HasState;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;

@Entity
@Table(name = "ENTITY_STATE")
public class EntityState {

    @Id
    @GeneratedValue
    long id;

    @Any(
            metaColumn = @Column(name = "entity_type", length = 4),
            fetch = FetchType.EAGER
    )
    @AnyMetaDef(
            idType = "long", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = Person.class, value = "P"),
                    @MetaValue(targetEntity = Task.class, value = "T")
                    // @MetaValue(targetEntity = Company.class, value = "C")
            }
    )
    @JoinColumn(name = "entity_id")
    HasState entity;

    String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HasState getEntity() {
        return entity;
    }

    public void setEntity(HasState entity) {
        this.entity = entity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
