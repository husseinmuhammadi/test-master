package com.javastudio.tutorial.model.to;

import com.javastudio.tutorial.model.base.EntityBase;
import com.javastudio.tutorial.security.crypto.annotation.Decrypted;

import javax.persistence.*;

@Entity
@Table(name = "CARD_MASTER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CARD_NUMBER"})
})
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "CARD_SEQ")
@NamedQueries({
        @NamedQuery(name = Card.FIND_ALL, query = "select t from Card t"),
})
public class Card extends EntityBase {

    public static final String FIND_ALL = "Card.findAll";

    @Decrypted
    @Column(name = "CARD_NUMBER", length = 100)
    private String pan;

    @Decrypted
    @Column(name = "PIN", length = 100)
    String pin;

    @Column(name = "PIN_OFFSET", length = 12)
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
