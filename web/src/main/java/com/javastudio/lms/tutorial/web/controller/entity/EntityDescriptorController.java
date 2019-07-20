package com.javastudio.lms.tutorial.web.controller.entity;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.EntityModelDescriptorService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.EntityModelDescriptor;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;

@Named
@ViewScoped
public class EntityDescriptorController extends ControllerBase<EntityModelDescriptor> implements Serializable {

    private static final long serialVersionUID = 3233666231649250158L;

    @Inject
    private Logger logger;

    @EJB
    EntityModelDescriptorService service;

    public EntityDescriptorController() {
        super(EntityModelDescriptor.class);
    }

    @Override
    public GeneralServiceApi<EntityModelDescriptor> getGeneralServiceApi() {
        return service;
    }

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    protected void afterLoad() {

    }

    public EntityModelDescriptor getEntityDescriptor() {
        return entity;
    }

    public void setEntityDescriptor(EntityModelDescriptor entityModelDescriptor) {
        this.entity = entityModelDescriptor;
    }

    LocalDateTime current = LocalDateTime.now();

    public LocalDateTime getCurrent() {
        return current;
    }

    public void setCurrent(LocalDateTime current) {
        this.current = current;
    }
}
