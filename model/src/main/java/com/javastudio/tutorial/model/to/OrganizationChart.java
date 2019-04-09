package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ORGANIZATION_CHART")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "ORGANIZATION_CHART_SEQ")
@NamedQueries({
        @NamedQuery(name = OrganizationChart.FIND_ALL, query = "select t from OrganizationChart t")
})
public class OrganizationChart extends EntityBase {

    public static final String FIND_ALL = "OrganizationChart.findAll";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private OrganizationChart parent;

    @OneToMany(mappedBy = "parent")
    private Set<OrganizationChart> children;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OrganizationChart getParent() {
        return parent;
    }

    public void setParent(OrganizationChart parent) {
        this.parent = parent;
    }

    public Set<OrganizationChart> getChildren() {
        return children;
    }

    public void setChildren(Set<OrganizationChart> children) {
        this.children = children;
    }
}