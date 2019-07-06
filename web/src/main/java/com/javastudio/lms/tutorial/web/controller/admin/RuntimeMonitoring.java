package com.javastudio.lms.tutorial.web.controller.admin;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named
@ApplicationScoped
public class RuntimeMonitoring {


    public String getJsfImplementationVersion() {
        Package p = FacesContext.class.getPackage();
        return p.getImplementationTitle() + " " + p.getImplementationVersion();
    }

    public String getImplementationTitle() {
        return FacesContext.class.getPackage().getImplementationTitle();
    }

    public String getImplementationVersion() {
        return FacesContext.class.getPackage().getImplementationVersion();
    }

    public String getImplementationVendor() {
        return FacesContext.class.getPackage().getImplementationVendor();
    }

    public String getName() {
        return FacesContext.class.getPackage().getName();
    }

    public String getSpecificationVersion() {
        return FacesContext.class.getPackage().getSpecificationVersion();
    }
}
