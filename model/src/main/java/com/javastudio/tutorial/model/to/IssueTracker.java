package com.javastudio.tutorial.model.to;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class IssueTracker {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    Person person;

    String errorDescription;

    String processingCode;
    String functionCode;

    String device;

    String intractionPoint;

    String mtiMessageClass;

    Boolean eod;

    Number issueNumber;

    SimulationInstruction simulationInstruction;

}
