package com.javastudio.tutorial.dto;

import java.util.Set;

public class OrganizationChartDTO extends DTOBase {

    private String corporateId;

    private UserDTO user;

    private String title;

    private OrganizationChartDTO parent;

    private Set<OrganizationChartDTO> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OrganizationChartDTO getParent() {
        return parent;
    }

    public void setParent(OrganizationChartDTO parent) {
        this.parent = parent;
    }

    public Set<OrganizationChartDTO> getChildren() {
        return children;
    }

    public void setChildren(Set<OrganizationChartDTO> children) {
        this.children = children;
    }

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
