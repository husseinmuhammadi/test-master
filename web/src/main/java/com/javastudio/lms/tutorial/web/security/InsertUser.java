package com.javastudio.lms.tutorial.web.security;

import com.javastudio.tutorial.api.UserService;
import com.javastudio.tutorial.dto.Person;
import com.javastudio.tutorial.dto.User;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by nebrass on 25/12/2015.
 */
@Startup
@Singleton
public class InsertUser {

    @EJB
    UserService userService;

    @Inject
    BCryptPasswordService passwordService;

    @Inject
    private Logger logger;

    @PostConstruct
    public void insert() {
        try {
            User user = userService.findByUsername("admin");
            if (user != null) {
                logger.info("User admin already exists.");
                return;
            }

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordService.encryptPassword("admin"));
            admin.setDescription("Administrator");
            admin.setEnabled(Boolean.TRUE);
            admin.setCreateBy("system");
            admin.setUpdateBy("system");

            Person person = new Person("Hossein", "Mohammadi");
            person.setCreateBy("system");
            person.setUpdateBy("system");

            admin.setPerson(person);

            /*
            Role role = new Role();
            role.setName("ADMIN");
            admin.setRoles(new HashSet<>());
            admin.getRoles().add(role);
            */

            this.userService.create(admin);
            logger.info("User admin added successfully");
        } catch (Exception e) {
            logger.warn("Could not add user admin", e);
        }
    }
}
