package com.javastudio.lms.tutorial.web.controller.issue;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.TestActionService;
import com.javastudio.tutorial.dto.TestAction;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class TestActionManager extends ManagerBase<TestAction> implements Serializable {

    private static final long serialVersionUID = 5476313993419092842L;

    List<TestAction> testPlans;

    @EJB
    TestActionService service;

    public TestActionManager() {
        super(TestAction.class);
    }

    @Override
    protected void onLoad() {

    }

    @Override
    public GeneralServiceApi<TestAction> getGeneralServiceApi() {
        return service;
    }

    public List<TestAction> getTestActions() {
        return entityList;
    }

}
