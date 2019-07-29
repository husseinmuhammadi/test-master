package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "TEST_PLAN")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "TEST_PLAN_SEQ")
@NamedQueries({
        @NamedQuery(name = TestPlan.FIND_ALL, query = "select t from TestPlan t"),
        @NamedQuery(name = TestPlan.FIND_BY_ISSUE, query = "select t from TestPlan t where t.issue = :issue"),
})
public class TestPlan extends EntityBase {

    public static final String FIND_ALL = "TestPlan.findAll";
    public static final String FIND_BY_ISSUE = "TestPlan.findByIssue";

    @ManyToOne
    @JoinColumn(name = "TEST_CASE_ID")
    TestCase testCase;

    @ManyToOne
    @JoinColumn(name = "RELEASE_ID")
    ProductRelease release;

    @ManyToOne
    @JoinColumn(name = "test_user_id")
    User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "plan_Date", nullable = false)
    private Date planDate;

    @ManyToOne
    @JoinColumn(name = "issue_id")
    Issue issue;

    @OneToMany(mappedBy = "testPlan")
    Set<TestAction> testActions;

    // region Getters & Setters

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    public ProductRelease getRelease() {
        return release;
    }

    public void setRelease(ProductRelease release) {
        this.release = release;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Set<TestAction> getTestActions() {
        return testActions;
    }

    public void setTestActions(Set<TestAction> testActions) {
        this.testActions = testActions;
    }

    // endregion Getters & Setters
}
