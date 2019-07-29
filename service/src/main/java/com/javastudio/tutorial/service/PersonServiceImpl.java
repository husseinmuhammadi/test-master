package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.PersonService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.PersonDao;
import com.javastudio.tutorial.model.to.Person;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(PersonService.class)
public class PersonServiceImpl extends GeneralServiceImpl<Person, com.javastudio.tutorial.dto.Person> implements PersonService {

    @Inject
    private Logger logger;

    @EJB
    PersonDao dao;

    public PersonServiceImpl() {
        super(Person.class, com.javastudio.tutorial.dto.Person.class);
    }

    @Override
    public GenericDao<Person> getGenericDao() {
        return dao;
    }
}
