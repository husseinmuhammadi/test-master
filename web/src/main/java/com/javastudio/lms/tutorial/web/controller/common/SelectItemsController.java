package com.javastudio.lms.tutorial.web.controller.common;

import com.javastudio.lms.tutorial.web.controller.base.Internationalization;
import com.javastudio.lms.tutorial.web.controller.base.Localization;
import com.javastudio.lms.tutorial.web.controller.base.LocalizedResource;
import com.javastudio.tutorial.api.MetaModelService;
import com.javastudio.tutorial.api.UserService;
import com.javastudio.tutorial.dto.UserDTO;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.metamodel.EntityType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Named
@SessionScoped
public class SelectItemsController extends Localization implements Internationalization, Serializable {

    private static final long serialVersionUID = -1704322412699194522L;

    private final LocalizedResource localizedResource;

    @EJB
    MetaModelService metaModelService;

    @EJB
    UserService userService;

    public SelectItemsController() {
        localizedResource = new LocalizedResource(this);
    }

    public Map<String, String> getEntityTypeItems() {
        Map<String, String> items = new HashMap<>();
        items.put("", localizedResource.getLabel("label.select.empty"));
        Set<EntityType<?>> entityTypes = metaModelService.getMetamodelEntityTypes();
        for (EntityType<?> entityType : entityTypes) {
            items.put(entityType.getName(), entityType.getName());
        }
//        for (EntityIndicator entityIndicator : ) {
//            items.put(entityIndicator.name(), localizedResource.getLabel(entityIndicator));
//        }
        return items;
    }
}
