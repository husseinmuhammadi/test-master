package com.javastudio.lms.tutorial.web.controller.card;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.lms.tutorial.web.security.BCryptPasswordService;
import com.javastudio.tutorial.api.CardService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.CardDTO;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CardController extends ControllerBase<CardDTO> implements Serializable {

    private static final long serialVersionUID = -3436888383534812269L;

    @Inject
    private Logger logger;

    @Inject
    BCryptPasswordService passwordService;

    @EJB
    CardService service;

    public CardController() {
        super(CardDTO.class);
    }

    @Override
    public GeneralServiceApi<CardDTO> getGeneralServiceApi() {
        return service;
    }

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    protected void afterLoad() {

    }

    public CardDTO getCard() {
        return super.entity;
    }

    public void setCard(CardDTO card) {
        super.entity = card;
    }
}
