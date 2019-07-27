package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.DashboardService;
import com.javastudio.tutorial.model.dao.DashboardDao;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.to.Dashboard;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(DashboardService.class)
public class DashboardServiceImpl extends GeneralServiceImpl<Dashboard, com.javastudio.tutorial.dto.Dashboard> implements DashboardService {

    @Inject
    private Logger logger;

    @EJB
    DashboardDao dao;

    public DashboardServiceImpl() {
        super(Dashboard.class, com.javastudio.tutorial.dto.Dashboard.class);
    }

    @Override
    public GenericDao<Dashboard> getGenericDao() {
        return dao;
    }
}
