package com.javastudio.lms.tutorial.web.controller.common;

import com.javastudio.lms.tutorial.web.controller.base.Internationalization;
import com.javastudio.lms.tutorial.web.controller.base.Localization;
import com.javastudio.lms.tutorial.web.controller.base.LocalizedResource;
import com.javastudio.tutorial.api.MetaModelService;
import com.javastudio.tutorial.api.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.persistence.metamodel.EntityType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Named
@ApplicationScoped
public class SelectItemsController extends Localization implements Internationalization, Serializable {

    private static final long serialVersionUID = -1704322412699194522L;

    private final LocalizedResource localizedResource;

    @EJB
    MetaModelService metaModelService;

    @EJB
    UserService userService;

    final SelectItem emptyItem;

    public SelectItemsController() {
        localizedResource = new LocalizedResource(this);
        emptyItem = new SelectItem(null, localizedResource.getLabel("label.select.empty"));
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

    public SelectItem getEmptyItem() {
        return emptyItem;
    }
}
