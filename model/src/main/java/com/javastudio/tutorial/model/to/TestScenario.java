package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_SCENARIO")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "TEST_SCENARIO_seq")
public class TestScenario extends EntityBase {


    @Column(name = "scenario", length = 2000, nullable = false)
    String scenario;

}
