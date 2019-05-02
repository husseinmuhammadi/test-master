package com.javastudio.tutorial.model.to;


import com.javastudio.tutorial.model.base.EntityBase;

import javax.enterprise.inject.Any;
import javax.persistence.*;

@Entity
@Table(name = "DASHBOARD")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "DASHBOARD_SEQ")
@NamedQueries(
        @NamedQuery(name = Dashboard.FIND_ALL,query = "select t from Dashboard t")
)
public class Dashboard extends EntityBase {

    public static final String FIND_ALL = "Dashboard.findAll";

}
