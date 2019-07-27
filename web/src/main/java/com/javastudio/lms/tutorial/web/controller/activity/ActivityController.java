package com.javastudio.lms.tutorial.web.controller.activity;

import com.javastudio.lms.tutorial.web.annotation.ShiroSecured;
import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.ActivityService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.ActivityDTO;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ShiroSecured
@Named
@ViewScoped
public class ActivityController extends ControllerBase<ActivityDTO> implements Serializable {

    private static final long serialVersionUID = -4360806817248079581L;

    @Inject
    private Logger logger;

    @EJB
    ActivityService service;

    public ActivityController() {
        super(ActivityDTO.class);
    }

    String permission;

    @Override
    public GeneralServiceApi<ActivityDTO> getGeneralServiceApi() {
        return service;
    }

    @Override
    public void prepare() {
        super.prepare();

        // entity.setPermission(new PermissionDTO(permission));
    }

    @Override
    protected void afterLoad() {

    }

    public ActivityDTO getActivity() {
        return super.entity;
    }

    public void setActivity(ActivityDTO activity) {
        super.entity = activity;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
