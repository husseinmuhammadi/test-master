package com.javastudio.lms.tutorial.web.controller.card;

import com.javastudio.lms.tutorial.web.controller.base.ManagerBase;
import com.javastudio.tutorial.api.GeneralServiceApi;
import com.javastudio.tutorial.api.CardService;
import com.javastudio.tutorial.dto.CardDTO;
import org.slf4j.Logger;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CardManager extends ManagerBase<CardDTO> implements Serializable {

    private static final long serialVersionUID = -9051371651827827993L;

    @Inject
    private Logger logger;

    @EJB
    CardService service;

    public CardManager() {
        super(CardDTO.class);
    }

    @Override
    protected void onLoad() {
        logger.info("");
    }

    @Override
    public GeneralServiceApi<CardDTO> getGeneralServiceApi() {
        return service;
    }

    public List<CardDTO> getCards() {
        return entityList;
    }
}
