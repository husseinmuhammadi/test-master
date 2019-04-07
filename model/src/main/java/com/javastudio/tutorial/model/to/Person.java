package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PERSON_SEQ")
@NamedQueries({
        @NamedQuery(name = Person.FIND_ALL, query = "select t from Person t"),
})
public class Person extends EntityBase {

    public static final String FIND_ALL = "Person.findAll";

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "national_code", length = 10)
    private String nationalCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
}
