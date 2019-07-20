package com.javastudio.lms.tutorial.web.controller.entity;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.EntityModelDescriptorService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.EntityModelDescriptor;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class EntityDescriptorManager extends ManagerBase<EntityModelDescriptor> implements Serializable {

    @Inject
    private Logger logger;

    @EJB
    EntityModelDescriptorService service;

    public EntityDescriptorManager() {
        super(EntityModelDescriptor.class);
    }

    @Override
    protected void onLoad() {
        logger.info("");
    }

    @Override
    public GeneralServiceApi<EntityModelDescriptor> getGeneralServiceApi() {
        return service;
    }

    public List<EntityModelDescriptor> getEntityModelDescriptors() {
        return entityList;
    }
}
