package com.homeypark.web_service.payment.application.internal.commandServices;

import com.homeypark.web_service.payment.domain.model.commands.CreateCardCommand;
import com.homeypark.web_service.payment.domain.model.commands.DeleteCardCommand;
import com.homeypark.web_service.payment.domain.model.entities.Card;
import com.homeypark.web_service.payment.domain.services.ICardCommandService;
import com.homeypark.web_service.payment.infrastructure.repositories.jpa.ICardRepository;
import com.homeypark.web_service.user.infrastructure.repositories.jpa.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardCommandService implements ICardCommandService {

    private final ICardRepository cardRepository;
    private final IUserRepository userRepository;

    public CardCommandService(ICardRepository cardRepository, IUserRepository userRepository) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Card> handle(CreateCardCommand command) {
        Card card = new Card(command);
        try {
            var user = userRepository.findById(command.userId());

            user.map((p)-> {
                card.setUser(p);
                return p;
            }).orElseThrow(()-> new IllegalArgumentException("User not founded"));

            var response = cardRepository.save(card);
            return Optional.of(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public void handle(DeleteCardCommand command){
        cardRepository.deleteById(command.cardId());
        System.out.println("Card Delete");
    }

}
