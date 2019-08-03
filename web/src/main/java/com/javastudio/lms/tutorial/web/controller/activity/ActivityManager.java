package com.javastudio.lms.tutorial.web.controller.activity;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.ActivityService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.Activity;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ActivityManager extends ManagerBase<Activity> implements Serializable {

    private static final long serialVersionUID = -9051371651827827993L;

    @Inject
    private Logger logger;

    @EJB
    ActivityService service;

    public ActivityManager() {
        super(Activity.class);
    }

    @Override
    protected void onLoad() {
        logger.info("");
    }

    @Override
    public GeneralServiceApi<Activity> getGeneralServiceApi() {
        return service;
    }

    public List<Activity> getActivities() {
        return entityList;
    }
}
