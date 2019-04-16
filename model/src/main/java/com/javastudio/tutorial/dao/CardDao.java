package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.model.to.Card;
import com.javastudio.tutorial.model.to.Person;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CardDao extends GenericDao<Card> {

    public CardDao() {
        super(Card.class);
    }

    @Override
    public List<Card> findAll() {
        return createNamedQuery(Card.FIND_ALL).getResultList();
    }
}
