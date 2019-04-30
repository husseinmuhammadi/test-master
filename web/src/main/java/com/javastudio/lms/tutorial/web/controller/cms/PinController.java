package com.javastudio.lms.tutorial.web.controller.cms;

import com.javastudio.lms.tutorial.web.controller.base.ControllerBase;
import com.javastudio.lms.tutorial.web.security.BCryptPasswordService;
import com.javastudio.tutorial.api.CardService;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.dto.CardDTO;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class PinController extends ControllerBase<CardDTO> implements Serializable {

    @Inject
    private Logger logger;

    @Inject
    BCryptPasswordService passwordService;

    @EJB
    CardService service;


    public PinController() {
        super(CardDTO.class);
    }

    @Override
    public GeneralServiceApi<CardDTO> getGeneralServiceApi() {
        return service;
    }

    @Override
    protected void afterLoad() {

    }

    public CardDTO getCard() {
        return entity;
    }

    public void setCard(CardDTO card) {
        this.entity = card;
    }

    public void actionListener(ActionEvent event) {
        logger.info("");
    }

    public String action() {
        logger.info("");

        String pinOffset = service.changePersonalIdentificationNumber(entity.getPan(), entity.getPin());
        entity.setPinOffset(pinOffset);
        service.update(entity);

        return null;
    }
}
