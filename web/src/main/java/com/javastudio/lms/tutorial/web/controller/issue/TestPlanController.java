package com.javastudio.lms.tutorial.web.controller.issue;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.TestPlanService;
import com.javastudio.tutorial.dto.Issue;
import com.javastudio.tutorial.dto.TestPlan;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named
@ViewScoped
public class TestPlanController extends ControllerBase<TestPlan> implements Serializable {

    private static final long serialVersionUID = -2653293800629162875L;

    TestPlan testPlan;

    @EJB
    TestPlanService service;

    public TestPlanController() {
        super(TestPlan.class);
    }

    @Override
    protected GeneralServiceApi getGeneralServiceApi() {
        return service;
    }

    @Override
    protected void afterLoad() {

    }

    public TestPlan getTestPlan() {
        return entity;
    }

    public void setTestPlan(TestPlan testPlan) {
        super.entity = testPlan;
    }

    public void onSelectIssue(SelectEvent event) {
        Issue issue = (Issue) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Issue Selected", "Id:" + issue.getId());

        FacesContext.getCurrentInstance().addMessage(null, message);

        getTestPlan().setIssue(issue);
    }
}
