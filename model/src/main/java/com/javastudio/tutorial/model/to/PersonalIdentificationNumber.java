package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "PIN_MASTER")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "PIN_SEQ")
@NamedQueries({
        @NamedQuery(name = PersonalIdentificationNumber.FIND_ALL, query = "select t from PersonalIdentificationNumber t"),
})
public class PersonalIdentificationNumber extends EntityBase {

    public static final String FIND_ALL = "PersonalIdentificationNumber.findAll";


}
