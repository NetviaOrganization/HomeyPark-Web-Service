package com.homeypark.web_service.payment.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.homeypark.web_service.payment.domain.model.commands.CreateCardCommand;
import com.homeypark.web_service.user.domain.model.entities.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double numCard;

    private Double cvv;

    private String date;

    private String holder;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    public Card(Double numCard, Double cvv, String date, String holder) {
        this.numCard = numCard;
        this.cvv = cvv;
        this.date = date;
        this.holder = holder;
    }

    public Card(CreateCardCommand command) {
        this.numCard = command.numCard();
        this.cvv = command.cvv();
        this.date = command.date();
        this.holder = command.holder();
    }

}
