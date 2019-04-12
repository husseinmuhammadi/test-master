package com.javastudio.lms.tutorial.web.controller.activity;

import com.javastudio.lms.tutorial.web.annotation.ShiroSecured;
import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.lms.tutorial.web.security.BCryptPasswordService;
import com.javastudio.tutorial.api.ActivityService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.ActivityDTO;
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

    @Inject
    BCryptPasswordService passwordService;

    @EJB
    ActivityService service;

    public ActivityController() {
        super(ActivityDTO.class);
    }

    EntityIndicator entityIndicator;

    String currentState;

    String nextState;

    @Override
    public GeneralServiceApi<ActivityDTO> getGeneralServiceApi() {
        return service;
    }

    @Override
    public void prepare() {
        super.prepare();
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
}
