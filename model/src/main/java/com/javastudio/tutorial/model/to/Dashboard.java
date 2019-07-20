package com.javastudio.tutorial.model.to;


import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.model.base.StateTracker;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;

@Entity
@Table(name = "DASHBOARD")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "DASHBOARD_SEQ")
@NamedQueries(
        @NamedQuery(name = Dashboard.FIND_ALL, query = "select t from Dashboard t")
)
public class Dashboard extends EntityBase {

    public static final String FIND_ALL = "Dashboard.findAll";

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
    private StateTracker stateTracker;

    private String entityState;

    public StateTracker getStateTracker() {
        return stateTracker;
    }

    public void setStateTracker(StateTracker stateTracker) {
        this.stateTracker = stateTracker;
    }
}
