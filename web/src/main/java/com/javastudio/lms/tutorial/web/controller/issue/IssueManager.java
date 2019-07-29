package com.javastudio.lms.tutorial.web.controller.issue;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.IssueService;
import com.javastudio.tutorial.dto.Issue;
import org.primefaces.PrimeFaces;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class IssueManager extends ManagerBase<Issue> implements Serializable {

    private static final long serialVersionUID = 3658346337440796951L;

    List<Issue> issues;

    @EJB
    IssueService service;


    public IssueManager() {
        super(Issue.class);
    }

    @Override
    protected void onLoad() {

    }

    @Override
    public GeneralServiceApi<Issue> getGeneralServiceApi() {
        return service;
    }

    public List<Issue> getIssues() {
        return entityList;
    }

}
