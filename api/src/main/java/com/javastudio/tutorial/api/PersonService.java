package com.javastudio.tutorial.api;

import com.javastudio.tutorial.dto.PersonDTO;

import javax.ejb.Local;

@Local
public interface PersonService extends GeneralServiceApi<PersonDTO> {

}
