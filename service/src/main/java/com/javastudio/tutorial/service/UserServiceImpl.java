package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.UserService;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.model.dao.UserDao;
import com.javastudio.tutorial.dto.UserDTO;
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
public class UserServiceImpl extends GeneralServiceImpl<User, UserDTO> implements UserService {

    @Inject
    private Logger logger;

    @EJB
    UserDao dao;

    public UserServiceImpl() {
        super(User.class, UserDTO.class);
    }

    @Override
    public GenericDao<User> getGenericDao() {
        return dao;
    }

    public UserDTO findByUsername(String username) {
        logger.info("Find user by username ...");
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        User user = dao.findByUsername(username);
        return user == null ? null : mapper.map(user, UserDTO.class);
    }

    public UserDTO findByEmail(String email) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        return mapper.map(dao.findByEmail(email), UserDTO.class);
    }

}
