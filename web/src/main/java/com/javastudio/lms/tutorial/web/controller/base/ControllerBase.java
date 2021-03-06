package com.javastudio.lms.tutorial.web.controller.base;

import com.javastudio.lms.tutorial.web.annotation.ShiroSecured;
import com.javastudio.lms.tutorial.web.controller.user.UserInformation;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.Activity;
import com.javastudio.tutorial.dto.DTOBase;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ShiroSecured
@Dependent
public abstract class ControllerBase<T extends DTOBase> extends Localization implements Internationalization {

    @Inject
    private Logger logger;

    @Inject
    UserInformation userInformation;

    private final LocalizedResource localizedResource;

    protected T entity;
    Class<T> entityBeanType;


    private Set<Activity> activities;

    private Long id;

    public ControllerBase(Class<T> entityBeanType) {
        localizedResource = new LocalizedResource(this);
        this.entityBeanType = entityBeanType;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected abstract GeneralServiceApi<T> getGeneralServiceApi();

    @PostConstruct
    protected void init() {
        try {
            entity = entityBeanType.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            logger.error("Could not create instance for " + entityBeanType.getName(), e);
        }
    }

    /**
     * Pre persist
     */
    public void prepare() {
        entity.setId(null);
    }

    public String create() {

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        try {
            // prepare entity
            prepare();

            getGeneralServiceApi().create(entity);
            context.addMessage(null, new FacesMessage(localizedResource.getMessage("request.success")));
            externalContext.getFlash().setKeepMessages(true);
            logger.info("entity saved successfully.");
            return afterCreate();
        } catch (Exception e) {
            String message = String.format("Could not save %s in database.", entity.getClass());
            logger.error(message, e);
            localizedResource.printErrorMessage(e);
        }

        return null;
    }


    protected String afterCreate() {
        return FacesContext.getCurrentInstance().getViewRoot().getViewId().replace("insert", "index") + "?faces-redirect=true";
    }

    public String update() {
        String url = null;
        try {
            entity.setUpdateBy(userInformation.getUsername());
            getGeneralServiceApi().update(entity);
            url = FacesContext.getCurrentInstance().getViewRoot().getViewId().replace("insert", "index") + "?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            localizedResource.printErrorMessage(e);
        }
        return url;
    }

    public String cancel() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        context.addMessage(null, new FacesMessage(localizedResource.getMessage("request.cancel")));
        externalContext.getFlash().setKeepMessages(true);

        // return context.getViewRoot().getViewId().replace("insert", "index") + "?faces-redirect=true";

        logger.info("Request canceled.");

        return "index.xhtml?faces-redirect=true";
    }

    // @RequiresPermissions("entity:delete")
    public String delete(Long id) {
        try {
            getGeneralServiceApi().delete(getGeneralServiceApi().find(id));
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, localizedResource.getMessage("request.success"), "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            logger.info(String.format("Entity %s with id %d is found", entity.getClass(), entity.getId()));
        } catch (Exception e) {
            String message = String.format("Could not remove entity %s with id %d", entity.getClass().getName(), entity.getId());
            logger.error(message, e);
            localizedResource.printErrorMessage(e);
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String refresh() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getViewRoot().getViewId() + "?faces-redirect=true";
    }

    /**
     * preRenderView
     */
    public void onLoad() {
        logger.info("ControllerBase --> onLoad");
        if (id != null) {
            entity = getGeneralServiceApi().find(id);
            if (entity == null) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().dispatch("index");
                } catch (Throwable e) {
                    logger.warn("Something wrong while dispatching to index", e);
                }
            }
        }

        afterLoad();
    }

    protected abstract void afterLoad();

    public String save() {
        try {
            audit();
            prepare();
            getGeneralServiceApi().create(entity);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(localizedResource.getMessage("request.success")));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            logger.info("entity saved successfully.");
            // Thread.sleep(3000);
            return "index?faces-redirect=true";
        } catch (Throwable e) {
            logger.error("Error on entity update", e);
            localizedResource.printErrorMessage(e);
        }
        return null;
    }

    public String edit() {
        try {
            entity.setUpdateBy(userInformation.getUsername());
            getGeneralServiceApi().update(entity);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(localizedResource.getMessage("request.success")));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            logger.info("entity edited successfully.");
            // Thread.sleep(3000);
            return "index?faces-redirect=true";
        } catch (Throwable e) {
            logger.error("Error while updating entity", e);
            localizedResource.printErrorMessage(e);
        }
        return null;
    }

    private void audit() {
        entity.setCreateBy(userInformation.getUsername());
        entity.setUpdateBy(userInformation.getUsername());
    }

    public String showPage(String response, boolean redirect) {
        logger.info(String.format("ControllerBase --> showPage(%s, %b)", response, redirect));
        if (redirect)
            response += "?faces-redirect=true";
        return response;
    }

    public String redirect() {
        String url = FacesContext.getCurrentInstance().getViewRoot().getViewId().replace("insert", "index") + "?faces-redirect=true";
        return url;
    }

    public void remove(T entity) {
        try {
            getGeneralServiceApi().delete(entity);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(localizedResource.getMessage("request.success")));
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            logger.info("entity deleted successfully.");
        } catch (Throwable e) {
            logger.error("Error while deleting entity", e);
            localizedResource.printErrorMessage(e);
        }
    }

    public void remove() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        Long id = Long.valueOf(params.get("id"));
        getGeneralServiceApi().delete(getGeneralServiceApi().find(id));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(localizedResource.getMessage("request.success")));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        logger.info("entity deleted successfully.");
    }

    public void facetListener(javax.faces.event.AjaxBehaviorEvent event) throws javax.faces.event.AbortProcessingException {
        logger.info("ControllerBase --> facetListener");
    }

    public void select(String outcome) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic(outcome, options, null);
    }
}
