package com.javastudio.lms.tutorial.web.controller.permission;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.PermissionService;
import com.javastudio.tutorial.dto.Permission;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PermissionManager extends ManagerBase<Permission> implements Serializable {

    private static final long serialVersionUID = -9051371651827827993L;

    @Inject
    private Logger logger;

    @EJB
    PermissionService service;

    public PermissionManager() {
        super(Permission.class);
    }

    @Override
    protected void onLoad() {
        logger.info("");
    }

    @Override
    public GeneralServiceApi<Permission> getGeneralServiceApi() {
        return service;
    }

    public List<Permission> getPeople() {
        return entityList;
    }
}
