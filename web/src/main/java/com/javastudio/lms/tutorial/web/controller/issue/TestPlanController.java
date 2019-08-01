package com.javastudio.lms.tutorial.web.controller.issue;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.IssueService;
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

    Long issueId;

    @EJB
    TestPlanService service;

    @EJB
    IssueService issueService;

    public TestPlanController() {
        super(TestPlan.class);
    }

    @Override
    protected GeneralServiceApi getGeneralServiceApi() {
        return service;
    }

    @Override
    protected void afterLoad() {
        if (issueId != null) {
            getTestPlan().setIssue(issueService.find(issueId));
        }
    }

    public TestPlan getTestPlan() {
        return entity;
    }

    public void setTestPlan(TestPlan testPlan) {
        super.entity = testPlan;
    }

    public void onSelectIssue(SelectEvent event) {
        getTestPlan().setIssue((Issue) event.getObject());
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }
}
