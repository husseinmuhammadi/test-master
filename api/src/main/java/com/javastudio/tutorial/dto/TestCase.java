package com.javastudio.tutorial.dto;

public class TestCase extends DTOBase {

    String title;

    boolean generalTestCase;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isGeneralTestCase() {
        return generalTestCase;
    }

    public void setGeneralTestCase(boolean generalTestCase) {
        this.generalTestCase = generalTestCase;
    }
}
