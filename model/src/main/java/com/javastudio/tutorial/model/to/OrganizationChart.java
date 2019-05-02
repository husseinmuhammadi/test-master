package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ORGANIZATION_CHART", uniqueConstraints = {
        @UniqueConstraint(name = "UQ_ORGANIZATION_CHART_01", columnNames = {"CORPORATE_ID", "USERNAME"})
})
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "ORGANIZATION_CHART_SEQ")
@NamedQueries({
        @NamedQuery(name = OrganizationChart.FIND_ALL, query = "select t from OrganizationChart t")
})
public class OrganizationChart extends EntityBase {

    public static final String FIND_ALL = "OrganizationChart.findAll";

    @Column(name = "CORPORATE_ID", length = 100)
    private String corporateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME", referencedColumnName = User.COLUMN_USERNAME)
    private User user;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private OrganizationChart parent;

    @OneToMany(mappedBy = "parent")
    private Set<OrganizationChart> children;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ORGANIZATION_CHART_ACTIVITY",
            joinColumns = {@JoinColumn(name = "ORGANIZATION_CHART_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ID", table = "ACTIVITY_MASTER")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"ORGANIZATION_CHART_ID", "ACTIVITY_ID"})}
    )
    private Set<Activity> activities;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }
}
