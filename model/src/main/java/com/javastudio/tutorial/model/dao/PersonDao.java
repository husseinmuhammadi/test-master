package com.javastudio.tutorial.model.dao;

import com.javastudio.tutorial.model.to.Person;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PersonDao extends GenericDao<Person> {

    public PersonDao() {
        super(Person.class);
    }

    @Override
    public List<Person> findAll() {
        return createNamedQuery(Person.FIND_ALL).getResultList();
    }
}
