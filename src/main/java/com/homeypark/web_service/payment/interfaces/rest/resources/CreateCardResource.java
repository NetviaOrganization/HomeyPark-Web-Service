package com.homeypark.web_service.payment.interfaces.rest.resources;

public record CreateCardResource(Double numCard,
                                 Double cvv,
                                 String date,
                                 String holder,
                                 Long userId) {
}
