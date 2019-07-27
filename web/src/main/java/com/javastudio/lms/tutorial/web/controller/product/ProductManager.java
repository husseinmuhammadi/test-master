package com.javastudio.lms.tutorial.web.controller.product;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.Product;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class ProductManager extends ManagerBase<Product> implements Serializable {

    private static final long serialVersionUID = -4293969918106599153L;

    public ProductManager() {
        super(Product.class);
    }

    @Override
    protected void onLoad() {

    }

    @Override
    public GeneralServiceApi<Product> getGeneralServiceApi() {
        return null;
    }
}
