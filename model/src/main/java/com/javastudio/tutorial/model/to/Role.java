package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "SECURITY_ROLE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NAME"})
})
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "SECURITY_ROLE_SEQ")
@NamedQueries({
        @NamedQuery(name = Role.FIND_ALL, query = "select t from Role t"),
})
public class Role extends EntityBase {

    public static final String FIND_ALL = "Role.findAll";

    @NotNull
    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ROLE_PERMISSION",
            joinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID", table = "SECURITY_PERMISSION")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"ROLE_ID", "PERMISSION_ID"})}
    )
    private Set<Permission> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
