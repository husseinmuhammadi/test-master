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

    @Any(
            metaColumn = @Column(name = "entity_type", length = 4),
            fetch = FetchType.EAGER
    )
    @AnyMetaDef(
            idType = "long", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = Person.class, value = "P"),
                    // @MetaValue(targetEntity = Company.class, value = "C")
                    @MetaValue(targetEntity = Task.class, value = "T"),
                    @MetaValue(targetEntity = OrganizationChart.class, value = "O"),
            }
    )
    @JoinColumn(name = "entity_id")
    private HasState entity;

    String status;

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
