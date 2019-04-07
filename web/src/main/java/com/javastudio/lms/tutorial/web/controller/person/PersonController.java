package com.javastudio.lms.tutorial.web.controller.person;

import com.javastudio.lms.tutorial.web.annotation.ShiroSecured;
import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.lms.tutorial.web.security.BCryptPasswordService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.PersonService;
import com.javastudio.tutorial.dto.PersonDTO;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ShiroSecured
@Named
@ViewScoped
public class PersonController extends ControllerBase<PersonDTO> implements Serializable {

    private static final long serialVersionUID = -4360806817248079581L;

    @Inject
    private Logger logger;

    @Inject
    BCryptPasswordService passwordService;

    @EJB
    PersonService service;

    public PersonController() {
        super(PersonDTO.class);
    }

    @Override
    public GeneralServiceApi<PersonDTO> getGeneralServiceApi() {
        return service;
    }

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    protected void afterLoad() {

    }

    public PersonDTO getPerson() {
        return super.entity;
    }

    public void setPerson(PersonDTO person) {
        super.entity = person;
    }
}
