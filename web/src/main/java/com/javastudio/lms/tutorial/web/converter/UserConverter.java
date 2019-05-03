package com.javastudio.lms.tutorial.web.converter;

import com.javastudio.tutorial.api.UserService;
import com.javastudio.tutorial.dto.UserDTO;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@ApplicationScoped
public class UserConverter implements Converter {

    @EJB
    UserService service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String username) {
        return service.findByUsername(username);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object user) {
        return ((UserDTO)user).getUsername();
    }
}
