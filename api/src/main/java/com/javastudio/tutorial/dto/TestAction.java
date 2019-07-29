package com.javastudio.tutorial.dto;

import java.util.Date;

public class TestAction extends DTOBase {

    TestPlan testPlan;

    Date actionDate;

    public TestPlan getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(TestPlan testPlan) {
        this.testPlan = testPlan;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
}
