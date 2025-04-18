package com.homeypark.web_service.parkings.application.internal.commandServices;

import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateLocationCommand;
import com.homeypark.web_service.parkings.domain.services.ILocationCommandService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.ILocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationCommandService implements ILocationCommandService {

    private final ILocationRepository locationRepository;

    public LocationCommandService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Optional<Location> handle(UpdateLocationCommand command) {
        var result = locationRepository.findById(command.locationId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Location does not exist");
        var locationToUpdate = result.get();
        try{
            var updatedLocation = locationRepository.save(locationToUpdate.updateLocation(command));
            return Optional.of(updatedLocation);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while updating location: " + e.getMessage());
        }
    }
}
