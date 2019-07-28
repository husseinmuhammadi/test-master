package com.javastudio.lms.tutorial.web.controller.issue;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.IssueService;
import com.javastudio.tutorial.dto.Issue;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class IssueManager extends ManagerBase<Issue> implements Serializable {

    private static final long serialVersionUID = -8112641736316431920L;

    List<Issue> issues;
    private Issue selectedIssue;

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

    public Issue getSelectedIssue() {
        return selectedIssue;
    }

    public void setSelectedIssue(Issue selectedIssue) {
        this.selectedIssue = selectedIssue;
    }

    public void onSelectIssue() {
        PrimeFaces.current().dialog().closeDynamic(selectedIssue);
    }
}
