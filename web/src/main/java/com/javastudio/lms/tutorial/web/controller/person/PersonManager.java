package com.javastudio.lms.tutorial.web.controller.person;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.PersonService;
import com.javastudio.tutorial.dto.Person;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PersonManager extends ManagerBase<Person> implements Serializable {

    private static final long serialVersionUID = -9051371651827827993L;

    @Inject
    private Logger logger;

    @EJB
    PersonService service;

    public PersonManager() {
        super(Person.class);
    }

    @Override
    protected void onLoad() {
        logger.info("");
    }

    @Override
    public GeneralServiceApi<Person> getGeneralServiceApi() {
        return service;
    }

    public List<Person> getPeople() {
        logger.info("PersonManager --> getPeople");
        return entityList;
    }


}
