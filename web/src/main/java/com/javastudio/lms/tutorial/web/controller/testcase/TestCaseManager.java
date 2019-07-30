package com.javastudio.lms.tutorial.web.controller.testcase;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.TestCaseService;
import com.javastudio.tutorial.dto.TestCase;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class TestCaseManager extends ManagerBase<TestCase> implements Serializable {

    private static final long serialVersionUID = 3658346337440796951L;

    List<TestCase> testCases;

    @EJB
    TestCaseService service;


    public TestCaseManager() {
        super(TestCase.class);
    }

    @Override
    protected void onLoad() {

    }

    @Override
    public GeneralServiceApi<TestCase> getGeneralServiceApi() {
        return service;
    }

    public List<TestCase> getTestCases() {
        return entityList;
    }

}
