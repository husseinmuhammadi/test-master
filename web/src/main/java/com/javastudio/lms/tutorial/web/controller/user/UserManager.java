package com.javastudio.lms.tutorial.web.controller.user;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.UserService;
import com.javastudio.tutorial.dto.User;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserManager extends ManagerBase<User> implements Serializable {

    private static final long serialVersionUID = -9051371651827827993L;

    @Inject
    private Logger logger;

    @EJB
    UserService service;

    public UserManager() {
        super(User.class);
    }

    @Override
    protected void onLoad() {
        logger.info("");
    }

    @Override
    public GeneralServiceApi<User> getGeneralServiceApi() {
        return service;
    }

    @Override
    protected String getLookupLabel(User selectedEntity) {
        return selectedEntity.getUsername();
    }


    public List<User> getUsers() {
        return entityList;
    }
}
