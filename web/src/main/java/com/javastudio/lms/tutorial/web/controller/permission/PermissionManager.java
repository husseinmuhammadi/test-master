package com.javastudio.lms.tutorial.web.controller.permission;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.PermissionService;
import com.javastudio.tutorial.api.UserService;
import com.javastudio.tutorial.dto.PermissionDTO;
import com.javastudio.tutorial.dto.UserDTO;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PermissionManager extends ManagerBase<PermissionDTO> implements Serializable {

    private static final long serialVersionUID = -9051371651827827993L;

    @Inject
    private Logger logger;

    @EJB
    PermissionService service;

    public PermissionManager() {
        super(PermissionDTO.class);
    }

    @Override
    protected void onLoad() {
        logger.info("");
    }

    @Override
    public GeneralServiceApi<PermissionDTO> getGeneralServiceApi() {
        return service;
    }

    public List<PermissionDTO> getPeople() {
        return entityList;
    }
}
