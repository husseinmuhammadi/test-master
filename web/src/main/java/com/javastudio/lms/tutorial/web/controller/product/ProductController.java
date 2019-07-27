package com.javastudio.lms.tutorial.web.controller.product;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class ProductController extends ControllerBase implements Serializable {

    private static final long serialVersionUID = -6401066604473984951L;

    @Override
    public GeneralServiceApi getGeneralServiceApi() {
        return null;
    }

    @Override
    protected void afterLoad() {

    }
}
