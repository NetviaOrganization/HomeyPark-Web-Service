package com.homeypark.web_service.parkings.domain.model.commands;

import java.time.LocalDateTime;

public record UpdateScheduleCommand(Long scheduleId,
                                    String day,
                                    LocalDateTime startTime,
                                    LocalDateTime endTime) {
}
