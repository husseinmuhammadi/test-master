package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "issue")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "ISSUE_SEQ")
@NamedQueries({
        @NamedQuery(name = Issue.FIND_ALL, query = "select t from Issue t"),
        @NamedQuery(name = Issue.FIND_BY_ISSUE_NO, query = "select t from Issue t where t.issueNo = :issueNo"),
})
public class Issue extends EntityBase {

    public static final String FIND_ALL = "Issue.findAll";
    public static final String FIND_BY_ISSUE_NO= "Issue.findByIssueNo";

    @Column(name = "issue_no")
    Long issueNo;

    @Column(name = "title")
    String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

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
    // endregion Getters & Setters
}
