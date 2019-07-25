package com.javastudio.tutorial.dto;

import java.util.Set;

public class OrganizationChart extends DTOBase {

    private String corporateId;

    private User user;

    private String title;

    private OrganizationChart parent;

    private Set<OrganizationChart> children;

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

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
