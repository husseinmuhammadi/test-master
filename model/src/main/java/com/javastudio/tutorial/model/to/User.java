package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name = "SECURITY_USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"USERNAME"}),
        // @UniqueConstraint(columnNames = {"USERNAME", "CORPORATE_ID"}),
})
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "USER_SEQ")
@NamedQueries({
        @NamedQuery(name = User.FIND_ALL, query = "select t from User t"),
        @NamedQuery(name = User.FIND_BY_USERNAME, query = "SELECT u FROM User u WHERE u.username = :username"),
})
public class User extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1415732038426448052L;

    public static final String FIND_ALL = "User.findAll";
    public static final String FIND_BY_USERNAME = "User.findByUsername";

    static final String COLUMN_USERNAME = "USERNAME";

    @NotNull
    @Column(name = COLUMN_USERNAME, length = 50, nullable = false)
    private String username;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLED", nullable = false/*, columnDefinition = "NUMBER(1,0) default 0"*/)
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", table = "SECURITY_ROLE")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_ID", "ROLE_ID"})}
    )
    private Set<Role> roles;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    Person person;

    Locale locale;

    @Column(name = "CORPORATE_ID", length = 100)
    private String corporateId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }
}
