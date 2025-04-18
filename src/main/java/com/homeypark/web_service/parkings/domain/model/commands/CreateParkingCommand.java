package com.homeypark.web_service.parkings.domain.model.commands;

public record CreateParkingCommand(
        Long userId,
        Double width,
        Double length,
        Double height,
        Double price,
        String phone,
        Integer space,
        String description,
        String address,
        String numDirection,
        String street,
        String district,
        String city,
        Double latitude,
        Double longitude
) {
}
