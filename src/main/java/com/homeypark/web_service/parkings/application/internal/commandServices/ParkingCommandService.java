package com.homeypark.web_service.parkings.application.internal.commandServices;

import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
import com.homeypark.web_service.parkings.domain.model.commands.DeleteParkingCommand;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateParkingCommand;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.domain.services.IParkingCommandService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.IParkingRepository;
import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.infrastructure.repositories.jpa.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingCommandService implements IParkingCommandService {
    private final IParkingRepository parkingRepository;
    private final IUserRepository userRepository;

    public ParkingCommandService(IParkingRepository parkingRepository, IUserRepository userRepository) {
        this.parkingRepository = parkingRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Optional<Parking> handle(CreateParkingCommand command) {
        Parking parking = new Parking(command);
        var userOptional = userRepository.findById(command.userId());
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found with ID: " + command.userId());
        }
        parking.setUser(userOptional.get());

        try{
            var response = parkingRepository.save(parking);
            return Optional.of(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Parking> handle(UpdateParkingCommand command) {
        var result = parkingRepository.findById(command.parkingId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Parking does not exist");
        var parkingToUpdate = result.get();
        try{
            var updatedParking= parkingRepository.save(parkingToUpdate.updatedParking(command));
            return Optional.of(updatedParking);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while updating parking: " + e.getMessage());
        }

    }

    @Override
    public void handle(DeleteParkingCommand command) {
        parkingRepository.deleteById(command.parkingId());

    }
}
