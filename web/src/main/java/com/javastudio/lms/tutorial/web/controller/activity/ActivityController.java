package com.javastudio.lms.tutorial.web.controller.activity;

import com.javastudio.lms.tutorial.web.annotation.ShiroSecured;
import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.ActivityService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.StateService;
import com.javastudio.tutorial.dto.ActivityDTO;
import com.javastudio.tutorial.dto.PermissionDTO;
import com.javastudio.tutorial.dto.StateDTO;
import com.javastudio.tutorial.type.EntityIndicator;
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

    @EJB
    StateService stateService;

    public ActivityController() {
        super(ActivityDTO.class);
    }

    EntityIndicator entityIndicator;

    String currentState;

    String nextState;

    String permission;

    @Override
    public GeneralServiceApi<ActivityDTO> getGeneralServiceApi() {
        return service;
    }

    @Override
    public void prepare() {
        super.prepare();

        entity.setCurrentState(new StateDTO(entityIndicator, currentState));
        // entity.setNextState(stateService.create(new StateDTO(entityIndicator, nextState)));
        entity.setPermission(new PermissionDTO(permission));
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

    public EntityIndicator getEntityIndicator() {
        return entityIndicator;
    }

    public void setEntityIndicator(EntityIndicator entityIndicator) {
        this.entityIndicator = entityIndicator;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
