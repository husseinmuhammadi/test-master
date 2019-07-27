package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_case")
public class TestCase extends EntityBase {

    @ManyToOne
    @JoinColumn(name = "TEST_SCENARIO_ID")
    TestScenario testScenario;

    boolean generalTestCase;

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

    // endregion Getters & Setters
}
