package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.UserService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.UserDao;
import com.javastudio.tutorial.model.to.User;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(UserService.class)
public class UserServiceImpl extends GeneralServiceImpl<User, com.javastudio.tutorial.dto.User> implements UserService {

    @Inject
    private Logger logger;

    @EJB
    UserDao dao;

    public UserServiceImpl() {
        super(User.class, com.javastudio.tutorial.dto.User.class);
    }

    @Override
    public GenericDao<User> getGenericDao() {
        return dao;
    }

    public com.javastudio.tutorial.dto.User findByUsername(String username) {
        logger.info("Find user by username ...");
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        User user = dao.findByUsername(username);
        return user == null ? null : mapper.map(user, com.javastudio.tutorial.dto.User.class);
    }

    public com.javastudio.tutorial.dto.User findByEmail(String email) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        return mapper.map(dao.findByEmail(email), com.javastudio.tutorial.dto.User.class);
    }

}
