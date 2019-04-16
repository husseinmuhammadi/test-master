package com.javastudio.lms.tutorial.web.controller.base;

import javax.faces.context.FacesContext;
import java.util.Locale;

public abstract class Localization {
    public Locale getLocale() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getViewRoot().getLocale();
    }
}
