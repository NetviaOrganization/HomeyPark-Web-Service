package com.homeypark.web_service.parkings.application.internal.queryServices;

import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllLocationsQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetParkingsByNearLatLngQuery;
import com.homeypark.web_service.parkings.domain.services.ILocationQueryService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.ILocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationQueryService implements ILocationQueryService {

    private final ILocationRepository locationRepository;

    public LocationQueryService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> handle(GetAllLocationsQuery query) {
        return locationRepository.findAll();
    }

}
