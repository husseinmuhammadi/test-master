package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "TEST_ACTION")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "TEST_ACTION_SEQ")
@NamedQueries({
        @NamedQuery(name = TestAction.FIND_ALL, query = "select t from TestAction t")
})
public class TestAction extends EntityBase {

    public static final String FIND_ALL = "TestAction.findAll";

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TEST_ACTION_CONDITION",
            joinColumns = {@JoinColumn(name = "TEST_ACTION_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "TEST_CONDITION_ID", referencedColumnName = "ID", table = "TEST_CONDITION")}
    )
    Set<TestCondition> testConditions;

    @OneToOne
    @JoinColumn(name = "actual_result_id")
    TestResult actualResult;

    @OneToOne
    @JoinColumn(name = "expected_result_id")
    TestResult expectedResult;

    @ManyToOne
    @JoinColumn(name = "test_plan_id")
    TestPlan testPlan;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "action_date")
    Date actionDate;

    @ManyToOne
    @JoinColumn(name = "TEST_CASE_ID")
    TestCase testCase;

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
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

    public TestResult getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(TestResult expectedResult) {
        this.expectedResult = expectedResult;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
}
