package com.homeypark.web_service.payment.domain.model.commands;

public record CreateCardCommand(Double numCard,
                                Double cvv,
                                String date,
                                String holder,
                                Long userId) {
}
