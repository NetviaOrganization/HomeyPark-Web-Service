package com.homeypark.web_service.parkings.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateScheduleResource(
        String day,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Long parkingId) {
}
