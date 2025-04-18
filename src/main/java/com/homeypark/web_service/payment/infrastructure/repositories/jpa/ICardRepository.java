package com.homeypark.web_service.payment.infrastructure.repositories.jpa;

import com.homeypark.web_service.payment.domain.model.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends JpaRepository<Card, Long> {
}
