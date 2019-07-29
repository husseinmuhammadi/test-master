package com.javastudio.lms.tutorial.web.controller.issue;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.TestPlanService;
import com.javastudio.tutorial.dto.Issue;
import com.javastudio.tutorial.dto.TestPlan;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class TestPlanManager extends ManagerBase<TestPlan> implements Serializable {

    private static final long serialVersionUID = 5869303916324093004L;

    List<TestPlan> testPlans;

    @EJB
    TestPlanService service;

    public TestPlanManager() {
        super(TestPlan.class);
    }

    @Override
    protected void onLoad() {

    }

    @Override
    public GeneralServiceApi<TestPlan> getGeneralServiceApi() {
        return service;
    }

    public List<TestPlan> getTestPlans() {
        return entityList;
    }

    // region Search

    Long issueId;

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    // endregion Search

    // region Overrides

    @Override
    public void populate() {
        super.populate();

        if (issueId != null) {
            super.entityList = service.findByIssueNo(new Issue(issueId));
        }
    }


    // endregion Overrides

}
