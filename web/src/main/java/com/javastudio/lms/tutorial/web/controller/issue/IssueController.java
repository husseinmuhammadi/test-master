package com.javastudio.lms.tutorial.web.controller.issue;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.IssueService;
import com.javastudio.tutorial.dto.Issue;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IssueController extends ControllerBase<Issue> implements Serializable {
    private static final long serialVersionUID = -169703137862397134L;

    Issue issue;

    @EJB
    IssueService service;

    public IssueController() {
        super(Issue.class);
    }

    @Override
    protected GeneralServiceApi getGeneralServiceApi() {
        return service;
    }

    @Override
    protected void afterLoad() {

    }

    public Issue getIssue() {
        return entity;
    }

    public void setIssue(Issue issue) {
        super.entity = issue;
    }
}
