package com.homeypark.web_service.payment.domain.services;

import com.homeypark.web_service.payment.domain.model.commands.CreateCardCommand;
import com.homeypark.web_service.payment.domain.model.commands.DeleteCardCommand;
import com.homeypark.web_service.payment.domain.model.entities.Card;

import java.util.Optional;

public interface ICardCommandService {
    Optional<Card> handle(CreateCardCommand command);
    void handle(DeleteCardCommand command);
}
