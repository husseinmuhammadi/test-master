package com.javastudio.tutorial.model.type;

import com.javastudio.tutorial.model.to.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityIndicatorTest {

    static Logger logger = LoggerFactory.getLogger(EntityIndicatorTest.class);

    @Test
    public void getInstanceByEntityIndicator() {
        EntityIndicator indicator = EntityIndicator.getInstance(EntityIndicator.Person.getCode());
        logger.info(indicator.getType().getName());
        logger.info(indicator.getCode());
    }

    @Test
    public void getInstanceByEntityType() {
        EntityIndicator indicator = EntityIndicator.getInstance(Person.class);
        logger.info(indicator.getType().getName());
        logger.info(indicator.getCode());
    }

    @Test
    public void getEntityTypeByIndicator() {
        EntityIndicator indicator = EntityIndicator.getInstance(EntityIndicator.Person.getCode());
        logger.info(EntityIndicator.Person.getCode() + " --> " + indicator.getType().getName());
    }

}