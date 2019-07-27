package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "test_action")
public class TestAction extends EntityBase {

    String testResult;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TEST_ACTION_CONDITION",
            joinColumns = {@JoinColumn(name = "TEST_ACTION_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "TEST_CONDITION_ID", referencedColumnName = "ID", table = "TEST_CONDITION")}
    )
    Set<TestCondition> testConditions;

    @ManyToOne
    @JoinColumn(name = "actual_result_id")
    TestResult actualResult;

    @ManyToOne
    @JoinColumn(name = "test_plan_id")
    TestPlan testPlan;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Set<TestCondition> getTestConditions() {
        return testConditions;
    }

    public void setTestConditions(Set<TestCondition> testConditions) {
        this.testConditions = testConditions;
    }

    public TestResult getActualResult() {
        return actualResult;
    }

    public void setActualResult(TestResult actualResult) {
        this.actualResult = actualResult;
    }

    public TestPlan getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(TestPlan testPlan) {
        this.testPlan = testPlan;
    }
}
