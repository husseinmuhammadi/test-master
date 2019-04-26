package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.CardService;
import com.javastudio.tutorial.model.dao.CardDao;
import com.javastudio.tutorial.model.dao.GenericDao;
import com.javastudio.tutorial.dto.CardDTO;
import com.javastudio.tutorial.model.to.Card;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(CardService.class)
public class CardServiceImpl extends GeneralServiceImpl<Card, CardDTO> implements CardService {

    @Inject
    private Logger logger;

//    @EJB
//    SecurityModule securityModule;

    @EJB
    CardDao dao;

    public CardServiceImpl() {
        super(Card.class, CardDTO.class);
    }

    @Override
    public GenericDao<Card> getGenericDao() {
        return dao;
    }

    @Override
    public String changePersonalIdentificationNumber(String cardNumber, String newPin) {
        return null;
    }
}
