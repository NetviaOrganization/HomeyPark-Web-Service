package com.homeypark.web_service.parkings.infrastructure.repositories.jpa;

import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location,Long> {
    List<Location> findByLatitudeBetweenAndLongitudeBetween(double minLatitude, double maxLatitude, double minLongitude, double maxLongitude);
}
