package com.homeypark.web_service.parkings.domain.services;

import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
import com.homeypark.web_service.parkings.domain.model.commands.CreateScheduleCommand;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateScheduleCommand;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;

import java.util.Optional;

public interface IScheduleCommandService {
    Optional<Schedule> handle(CreateScheduleCommand command);
    Optional<Schedule> handle(UpdateScheduleCommand command);
}
