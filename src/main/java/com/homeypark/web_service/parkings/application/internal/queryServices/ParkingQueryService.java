package com.homeypark.web_service.parkings.application.internal.queryServices;

import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.domain.model.queries.GetAllParkingQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetParkingByIdQuery;
import com.homeypark.web_service.parkings.domain.model.queries.GetParkingListByUserId;
import com.homeypark.web_service.parkings.domain.model.queries.GetParkingsByNearLatLngQuery;
import com.homeypark.web_service.parkings.domain.services.IParkingQueryService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.IParkingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingQueryService implements IParkingQueryService {
    private final IParkingRepository parkingRepository;


    public ParkingQueryService(IParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }


    @Override
    public List<Parking> handle(GetAllParkingQuery query) {
        return parkingRepository.findAll();
    }

    @Override
    public Optional<Parking> handle(GetParkingByIdQuery query) {
        return parkingRepository.findById(query.parkingId());
    }

    @Override
    public List<Parking> handle(GetParkingListByUserId query) {
        return parkingRepository.findByUserId(query.userId());
    }

    @Override
    public List<Parking> handle(GetParkingsByNearLatLngQuery query) {

        List<Parking> parkingList = parkingRepository.findAll();

        parkingList.removeIf(parking -> {
            double earthRadius = 6371; // Radio de la Tierra en kilómetros
            double dLat = Math.toRadians(parking.getLocation().getLatitude() - query.latitude());
            double dLng = Math.toRadians(parking.getLocation().getLongitude() - query.longitude());
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                    Math.cos(Math.toRadians(query.latitude())) * Math.cos(Math.toRadians(parking.getLocation().getLatitude())) *
                            Math.sin(dLng / 2) * Math.sin(dLng / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = earthRadius * c;
            return distance > 1;
        });

        return parkingList;
    }
}
