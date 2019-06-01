package com.javastudio.lms.tutorial.web.controller.permission;

import com.javastudio.lms.tutorial.web.annotation.ShiroSecured;
import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.lms.tutorial.web.security.BCryptPasswordService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.PermissionService;
import com.javastudio.tutorial.dto.PermissionDTO;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ShiroSecured
@Named
@ViewScoped
public class PermissionController extends ControllerBase<PermissionDTO> implements Serializable {

    private static final long serialVersionUID = -4360806817248079581L;

    @Inject
    private Logger logger;

    @Inject
    BCryptPasswordService passwordService;

    @EJB
    PermissionService service;

    public PermissionController() {
        super(PermissionDTO.class);
    }

    @Override
    public GeneralServiceApi<PermissionDTO> getGeneralServiceApi() {
        return service;
    }

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    protected void afterLoad() {

    }

    public PermissionDTO getPermission() {
        return super.entity;
    }

    public void setPermission(PermissionDTO person) {
        super.entity = person;
    }
}