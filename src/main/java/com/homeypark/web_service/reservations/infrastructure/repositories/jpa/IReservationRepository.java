package com.homeypark.web_service.reservations.infrastructure.repositories.jpa;

import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.reservations.domain.model.valueobject.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByStatus(Status status);
    List<Reservation> findByStatusIn(List<Status> statusList);
    List<Reservation> findByHostId(Long hostId);
    List<Reservation> findByGuestId(Long guestId);
}
