package com.javastudio.lms.tutorial.web.controller.person;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.lms.tutorial.web.security.BCryptPasswordService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.PersonService;
import com.javastudio.tutorial.dto.Person;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;

@Named
@ViewScoped
public class PersonController extends ControllerBase<Person> implements Serializable {

    private static final long serialVersionUID = 3233666231649250158L;

    @Inject
    private Logger logger;

    @Inject
    BCryptPasswordService passwordService;

    @EJB
    PersonService service;

    public PersonController() {
        super(Person.class);
    }

    @Override
    public GeneralServiceApi<Person> getGeneralServiceApi() {
        return service;
    }

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    protected void afterLoad() {

    }

    public Person getPerson() {
        return super.entity;
    }

    public void setPerson(Person person) {
        super.entity = person;
    }

    LocalDateTime current = LocalDateTime.now();

    public LocalDateTime getCurrent() {
        return current;
    }

    public void setCurrent(LocalDateTime current) {
        this.current = current;
    }
}
