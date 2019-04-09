package com.javastudio.tutorial.dto;

import java.util.Set;

public class OrganizationChartDTO extends DataTransferObject {

    private PersonDTO person;

    private String title;

    private OrganizationChartDTO parent;

    private Set<OrganizationChartDTO> children;

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

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
}
