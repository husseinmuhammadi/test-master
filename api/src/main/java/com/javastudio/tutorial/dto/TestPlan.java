package com.javastudio.tutorial.dto;

public class TestPlan extends DTOBase {

    Issue issue;

    User user;

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
