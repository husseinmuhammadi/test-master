package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "test_case")
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "test_case_seq")
@NamedQueries({
        @NamedQuery(name = TestCase.FIND_ALL, query = "select t from TestCase t")
})
public class TestCase extends EntityBase {

    public static final String FIND_ALL = "TestCase.findAll";

    @ManyToOne
    @JoinColumn(name = "TEST_SCENARIO_ID")
    TestScenario testScenario;

    boolean generalTestCase;

    String title;

    // region Getters & Setters

    public TestScenario getTestScenario() {
        return testScenario;
    }

    public void setTestScenario(TestScenario testScenario) {
        this.testScenario = testScenario;
    }

    public boolean isGeneralTestCase() {
        return generalTestCase;
    }

    public void setGeneralTestCase(boolean generalTestCase) {
        this.generalTestCase = generalTestCase;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // endregion Getters & Setters
}
