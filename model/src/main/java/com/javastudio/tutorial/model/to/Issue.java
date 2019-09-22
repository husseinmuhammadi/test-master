package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "issue")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "ISSUE_SEQ")
@NamedQueries({
        @NamedQuery(name = Issue.FIND_ALL, query = "select t from Issue t"),
        @NamedQuery(name = Issue.FIND_BY_ISSUE_NO, query = "select t from Issue t where t.issueNo = :issueNo"),
})
public class Issue extends EntityBase {

    // region Constants
    public static final String FIND_ALL = "Issue.findAll";
    public static final String FIND_BY_ISSUE_NO = "Issue.findByIssueNo";
    // endregion Constants

    // region Properties
    @Column(name = "issue_no")
    Long issueNo;

    @Column(name = "title")
    String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "release_id")
    Release release;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "issue_test_case",
            joinColumns = {@JoinColumn(name = "ISSUE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "TEST_CASE_ID", referencedColumnName = "ID", table = "TEST_CASE")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"ISSUE_ID", "TEST_CASE_ID"})}
    )
    Set<TestCase> testCases;
    // endregion Properties

    // region Getters & Setters
    public Long getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(Long issueNo) {
        this.issueNo = issueNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public Set<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(Set<TestCase> testCases) {
        this.testCases = testCases;
    }
    // endregion Getters & Setters
}
