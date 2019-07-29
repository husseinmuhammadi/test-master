package com.javastudio.lms.tutorial.web.controller.product;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.Product;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class ProductController extends ControllerBase implements Serializable {

    private static final long serialVersionUID = -6401066604473984951L;

    public ProductController() {
        super(Product.class);
    }

    @Override
    public GeneralServiceApi getGeneralServiceApi() {
        return null;
    }

    @Override
    protected void afterLoad() {

    }
}
