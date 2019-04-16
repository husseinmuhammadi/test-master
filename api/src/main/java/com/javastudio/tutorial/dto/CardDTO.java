package com.javastudio.tutorial.dto;

public class CardDTO extends DTOBase {

    private String pan;

    String pin;

    String pinOffset;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPinOffset() {
        return pinOffset;
    }

    public void setPinOffset(String pinOffset) {
        this.pinOffset = pinOffset;
    }
}
