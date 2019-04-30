package com.javastudio.lms.tutorial.web.controller.common;

import com.javastudio.lms.tutorial.web.controller.base.Internationalization;
import com.javastudio.lms.tutorial.web.controller.base.Localization;
import com.javastudio.lms.tutorial.web.controller.base.LocalizedResource;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Named
@SessionScoped
public class SelectItemsController extends Localization implements Internationalization, Serializable {

    private static final long serialVersionUID = -1704322412699194522L;

    private final LocalizedResource localizedResource;

    public SelectItemsController() {
        localizedResource = new LocalizedResource(this);
    }

    public Map<String, String> getEntityIndicatorItems() {
        Map<String, String> items = new HashMap<String, String>();
        items.put("", localizedResource.getLabel("label.select.empty"));
//        for (EntityIndicator entityIndicator : EntityIndicator.values()) {
//            items.put(entityIndicator.name(), localizedResource.getLabel(entityIndicator));
//        }
        return items;
    }
}
