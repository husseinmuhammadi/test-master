package com.javastudio.lms.tutorial.web.controller.issue;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.TestActionService;
import com.javastudio.tutorial.dto.TestAction;
import com.javastudio.tutorial.dto.TestCase;
import com.javastudio.tutorial.dto.TestPlan;
import org.primefaces.event.SelectEvent;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class TestActionController extends ControllerBase<TestAction> implements Serializable {

    private static final long serialVersionUID = 1822078413538292981L;

    TestAction testAction;

    @EJB
    TestActionService service;

    public TestActionController() {
        super(TestAction.class);
    }

    @Override
    protected GeneralServiceApi getGeneralServiceApi() {
        return service;
    }

    @Override
    protected void afterLoad() {

    }

    public TestAction getTestAction() {
        return entity;
    }

    public void setTestAction(TestAction testAction) {
        super.entity = testAction;
    }

    public void onSelectTestPlan(SelectEvent event) {
        getTestAction().setTestPlan((TestPlan) event.getObject());
    }

    public void onSelectTestCase(SelectEvent event) {
        getTestAction().setTestCase((TestCase) event.getObject());
    }
}
