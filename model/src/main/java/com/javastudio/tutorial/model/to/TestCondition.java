package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "test_condition")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "TEST_CONDITION_SEQ")
public class TestCondition extends EntityBase {

    String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
