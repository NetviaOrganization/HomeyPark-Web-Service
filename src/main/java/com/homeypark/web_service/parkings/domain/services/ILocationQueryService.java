package com.homeypark.web_service.parkings.domain.services;

import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllLocationsQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetParkingsByNearLatLngQuery;

import java.util.List;

public interface ILocationQueryService {

    List<Location> handle(GetAllLocationsQuery query);
}
