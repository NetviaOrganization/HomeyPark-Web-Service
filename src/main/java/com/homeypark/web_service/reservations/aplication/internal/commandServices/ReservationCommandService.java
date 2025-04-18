package com.homeypark.web_service.reservations.aplication.internal.commandServices;

import com.homeypark.web_service.reservations.aplication.internal.outboundservices.acl.ExternalUserService;
import com.homeypark.web_service.reservations.domain.model.commands.CreateReservationCommand;
import com.homeypark.web_service.reservations.domain.model.commands.UpdateReservationCommand;
import com.homeypark.web_service.reservations.domain.model.commands.UpdateStatusCommand;
import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.reservations.domain.model.valueobject.Status;
import com.homeypark.web_service.reservations.domain.services.IReservationCommandService;
import com.homeypark.web_service.reservations.infrastructure.repositories.jpa.IReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationCommandService implements IReservationCommandService {
    private final IReservationRepository reservationRepository;
    private final ExternalUserService externalUserService;

    public ReservationCommandService(IReservationRepository reservationRepository, ExternalUserService externalUserService) {
        this.reservationRepository = reservationRepository;
        this.externalUserService = externalUserService;
    }

    @Override
    public Optional<Reservation> handle(CreateReservationCommand command) {
        if (!externalUserService.checkUserExistById(command.guestId())||!externalUserService.checkUserExistById(command.hostId())) {
            throw new IllegalArgumentException("Guest or Host not found");
        }
        var reservation = new Reservation(command);
        reservation.setStatus(Status.Pending);
        try {
            var response = reservationRepository.save(reservation);
            return Optional.of(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Reservation> handle(UpdateReservationCommand command) {
        var result = reservationRepository.findById(command.reservationId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Reservation does not exist");
        var reservationToUpdate = result.get();
        try{
            var updatedReservation= reservationRepository.save(reservationToUpdate.updatedReservation(command));
            return Optional.of(updatedReservation);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while updating reservation: " + e.getMessage());
        }
    }

    @Override
    public Optional<Reservation> handle(UpdateStatusCommand command) {
        var result = reservationRepository.findById(command.reservationId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Reservation does not exist");
        var statusToUpdate = result.get();
        try {
            var updatedStatus = reservationRepository.save(statusToUpdate.updatedStatus(command));
            return Optional.of(updatedStatus);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while updating status: "+ e.getMessage());
        }
    }
}
