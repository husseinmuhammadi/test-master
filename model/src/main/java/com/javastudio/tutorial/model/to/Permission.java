package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "Permission", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"permission"})
})
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "Permission_SEQ")
@NamedQueries({
        @NamedQuery(name = Permission.FIND_ALL, query = "select t from Permission t"),
})
public class Permission extends EntityBase {

    public static final String FIND_ALL = "Permission.findAll";

    @Column(name = "permission", length = 60)
    String permission;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
