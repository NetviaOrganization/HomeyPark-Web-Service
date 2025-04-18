package com.homeypark.web_service.parkings.infrastructure.repositories.jpa;

import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IParkingRepository extends JpaRepository<Parking, Long> {
    @Query("SELECT p FROM Parking p JOIN p.user u WHERE u.id = ?1")
    List<Parking> findByUserId(Long id);
}
