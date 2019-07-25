package com.javastudio.tutorial.api;

import com.javastudio.tutorial.dto.Person;

import javax.ejb.Local;

@Local
public interface PersonService extends GeneralServiceApi<Person> {

}
