package com.javastudio.lms.tutorial.web.controller.testcase;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.TestCaseService;
import com.javastudio.tutorial.dto.TestCase;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class TestCaseController extends ControllerBase<TestCase> implements Serializable {
    private static final long serialVersionUID = -169703137862397134L;

    TestCase testCase;

    @EJB
    TestCaseService service;

    public TestCaseController() {
        super(TestCase.class);
    }

    @Override
    protected GeneralServiceApi getGeneralServiceApi() {
        return service;
    }

    @Override
    protected void afterLoad() {

    }

    public TestCase getTestCase() {
        return entity;
    }

    public void setTestCase(TestCase testCase) {
        this.entity = testCase;
    }
}
