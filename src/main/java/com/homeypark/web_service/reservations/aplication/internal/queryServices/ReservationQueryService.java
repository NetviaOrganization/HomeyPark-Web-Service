package com.homeypark.web_service.reservations.aplication.internal.queryServices;

import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.reservations.domain.model.queries.*;
import com.homeypark.web_service.reservations.domain.model.valueobject.Status;
import com.homeypark.web_service.reservations.domain.services.IReservationQueryService;
import com.homeypark.web_service.reservations.infrastructure.repositories.jpa.IReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationQueryService implements IReservationQueryService {

    private final IReservationRepository reservationRepository;

    public ReservationQueryService(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> handle(GetAllReservationsQuery query) {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> handle(GetReservationByIdQuery query) {
        return reservationRepository.findById(query.reservationId());
    }

    @Override
    public List<Reservation> handle(GetInProgressReservationQuery query) {
        return reservationRepository.findByStatus(Status.InProgress);
    }

    @Override
    public List<Reservation> handle(GetPastReservationQuery query) {
        List<Status> pastStatuses = Arrays.asList(Status.Completed, Status.Cancelled);
        return reservationRepository.findByStatusIn(pastStatuses);
    }

    @Override
    public List<Reservation> handle(GetUpComingReservationQuery query) {
        List<Status> comingStatuses = Arrays.asList(Status.Pending, Status.Approved);
        return reservationRepository.findByStatusIn(comingStatuses);
    }

    @Override
    public List<Reservation> handle(GetReservationsByHostIdQuery query) {
        return reservationRepository.findByHostId(query.hostId());
    }

    @Override
    public List<Reservation> handle(GetReservationsByGuestIdQuery query) {
        return reservationRepository.findByGuestId(query.guestId());
    }
}
