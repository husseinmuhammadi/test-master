package com.javastudio.tutorial.dto;

public class PersonDTO extends DTOBase {

    public PersonDTO() {
    }

    public PersonDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String firstName;

    private String lastName;

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
}
