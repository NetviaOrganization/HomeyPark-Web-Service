package com.homeypark.web_service.payment.application.internal.queryServices;

import com.homeypark.web_service.payment.domain.model.entities.Card;
import com.homeypark.web_service.payment.domain.model.queries.GetAllCardsQuery;
import com.homeypark.web_service.payment.domain.services.ICardQueryService;
import com.homeypark.web_service.payment.infrastructure.repositories.jpa.ICardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardQueryService implements ICardQueryService {

    private final ICardRepository cardRepository;

    public CardQueryService(ICardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> handle(GetAllCardsQuery query) {
        return cardRepository.findAll();
    }

}
