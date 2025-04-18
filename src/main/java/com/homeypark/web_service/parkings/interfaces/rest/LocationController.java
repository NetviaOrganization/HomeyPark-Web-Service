package com.homeypark.web_service.parkings.interfaces.rest;

import com.homeypark.web_service.parkings.application.internal.commandServices.LocationCommandService;
import com.homeypark.web_service.parkings.application.internal.queryServices.LocationQueryService;
import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllLocationsQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetParkingsByNearLatLngQuery;
import com.homeypark.web_service.parkings.interfaces.rest.resources.LocationResource;
import com.homeypark.web_service.parkings.interfaces.rest.resources.UpdateLocationResource;
import com.homeypark.web_service.parkings.interfaces.rest.transformers.LocationResourceFromEntityAssembler;
import com.homeypark.web_service.parkings.interfaces.rest.transformers.UpdateLocationCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/location")
@Tag(name = "Location", description = "Location Management Endpoints")
public class LocationController {
    private final LocationCommandService locationCommandService;
    private final LocationQueryService locationQueryService;

    public LocationController(LocationCommandService locationCommandService, LocationQueryService locationQueryService) {
        this.locationCommandService = locationCommandService;
        this.locationQueryService = locationQueryService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody UpdateLocationResource updateLocationResource){
        var updateLocationCommand = UpdateLocationCommandFromResourceAssembler.toCommandFromResource(id, updateLocationResource);
        var updatedLocation = locationCommandService.handle(updateLocationCommand);
        return updatedLocation.map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping
    public ResponseEntity<List<LocationResource>> getAllLocation(){
        var getAllLocationQuery = new GetAllLocationsQuery();
        var locationList = locationQueryService.handle(getAllLocationQuery);

        var resource = locationList.stream().map(LocationResourceFromEntityAssembler::toResourceFromEntity).toList();

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
