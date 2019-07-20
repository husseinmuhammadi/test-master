package com.javastudio.lms.tutorial.web.controller.entity;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.EntityModelDescriptorService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.EntityModelDescriptorDTO;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.io.Serializable;

public class EntityManager extends ManagerBase<EntityModelDescriptorDTO> implements Serializable {

    @Inject
    private Logger logger;

    @EJB
    EntityModelDescriptorService service;

    public EntityManager() {
        super(EntityModelDescriptorDTO.class);
    }

    @Override
    protected void onLoad() {
        logger.info("");
    }

    @Override
    public GeneralServiceApi<EntityModelDescriptorDTO> getGeneralServiceApi() {
        return service;
    }
}
