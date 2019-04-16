package com.javastudio.tutorial.api;

import com.javastudio.tutorial.dto.CardDTO;

public interface CardService extends GeneralServiceApi<CardDTO> {

    String changePersonalIdentificationNumber(String cardNumber, String newPin);
}
