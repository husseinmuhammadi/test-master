package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "release")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "seq_release")
public class Release extends EntityBase {

    @Column(name = "release_no", length = 100)
    private String releaseNo;

    @Column(name = "release_description", length = 400)
    private String releaseDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME", referencedColumnName = User.COLUMN_USERNAME)
    private User user;

    @OneToMany(mappedBy = "release")
    private Set<Issue> issues;

    public String getReleaseNo() {
        return releaseNo;
    }

    public void setReleaseNo(String releaseNo) {
        this.releaseNo = releaseNo;
    }

    public String getReleaseDescription() {
        return releaseDescription;
    }

    public void setReleaseDescription(String releaseDescription) {
        this.releaseDescription = releaseDescription;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
