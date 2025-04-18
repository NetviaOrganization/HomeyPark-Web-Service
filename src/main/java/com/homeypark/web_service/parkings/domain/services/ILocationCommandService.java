package com.homeypark.web_service.parkings.domain.services;

import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateLocationCommand;

import java.util.Optional;

public interface ILocationCommandService {
    Optional<Location> handle(UpdateLocationCommand command);
}
