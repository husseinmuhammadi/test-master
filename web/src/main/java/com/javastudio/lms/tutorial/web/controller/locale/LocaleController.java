package com.javastudio.lms.tutorial.web.controller.locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
public class LocaleController implements Serializable {

    private static final long serialVersionUID = -535164167821330135L;

    private Locale locale;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }
    public String getCountry() {
        return locale.getCountry();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    public void changeLocale(String language, String country) {
        locale = new Locale(language, country);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    // https://stackoverflow.com/questions/4830588/localization-in-jsf-how-to-remember-selected-locale-per-session-instead-of-per
    //    public void resetLocale(@Observes @BeforePhase(JsfPhaseId.RENDER_RESPONSE) PhaseEvent event) {
    //        event.getFacesContext().getViewRoot().setLocale(this.locale);
    //    }
}
