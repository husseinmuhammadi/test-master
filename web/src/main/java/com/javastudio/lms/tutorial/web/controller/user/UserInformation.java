package com.javastudio.lms.tutorial.web.controller.user;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;

@SessionScoped
public class UserInformation implements Serializable {
    private String username;
    private Locale locale;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
