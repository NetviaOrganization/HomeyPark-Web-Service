package com.homeypark.web_service.payment.domain.services;

import com.homeypark.web_service.payment.domain.model.entities.Card;
import com.homeypark.web_service.payment.domain.model.queries.GetAllCardsQuery;

import java.util.List;

public interface ICardQueryService {
    List<Card> handle(GetAllCardsQuery query);
}
