package com.javastudio.tutorial.model.listener;

import com.javastudio.tutorial.model.base.StateTracker;
import com.javastudio.tutorial.model.dao.DashboardDao;
import com.javastudio.tutorial.model.to.Dashboard;

import javax.ejb.EJB;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class StateTrackerListener {

    @EJB
    DashboardDao dashboardDao;

    @PrePersist
    public void prePersist(StateTracker tracker) {
        addToDashboard(tracker);
    }

    @PreUpdate
    public void preUpdate(StateTracker tracker) {
        Dashboard dashboard = dashboardDao.findByEntityState(tracker);
        if (dashboard == null) {
            addToDashboard(tracker);
        }
    }

    private void addToDashboard(StateTracker tracker) {
        Dashboard dashboard = new Dashboard();
        dashboard.setStateTracker(tracker);
        dashboard.setEntityState(tracker.getState());
        dashboard.setState("E");
        dashboardDao.create(dashboard);
    }
}
