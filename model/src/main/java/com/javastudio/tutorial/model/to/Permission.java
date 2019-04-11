package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "SECURITY_PERMISSION", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "SECURITY_PERMISSION_SEQ")
@NamedQueries({
        @NamedQuery(name = Permission.FIND_ALL, query = "select t from Permission t"),
})
public class Permission extends EntityBase {

    public static final String FIND_ALL = "Permission.findAll";

    public static final String DB_COLUMN_NAME = "NAME";

    @Column(name = DB_COLUMN_NAME, length = 60)
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
