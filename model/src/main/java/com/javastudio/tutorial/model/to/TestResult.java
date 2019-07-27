package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Test_Result")
@SequenceGenerator(name = "seq_generator", sequenceName = "Test_Result_seq")
public class TestResult extends EntityBase {

    String result;

}
