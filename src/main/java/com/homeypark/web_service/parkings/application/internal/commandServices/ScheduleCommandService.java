package com.homeypark.web_service.parkings.application.internal.commandServices;

import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import com.homeypark.web_service.parkings.domain.model.commands.CreateScheduleCommand;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateParkingCommand;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateScheduleCommand;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.domain.services.IScheduleCommandService;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.IParkingRepository;
import com.homeypark.web_service.parkings.infrastructure.repositories.jpa.IScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleCommandService implements IScheduleCommandService {
    private final IScheduleRepository scheduleRepository;
    private final IParkingRepository parkingRepository;

    public ScheduleCommandService(IScheduleRepository scheduleRepository, IParkingRepository parkingRepository) {
        this.scheduleRepository = scheduleRepository;
        this.parkingRepository = parkingRepository;
    }

    @Override
    public Optional<Schedule> handle(CreateScheduleCommand command) {
        Schedule schedule = new Schedule(command);
        try {
            var parking = parkingRepository.findById(command.parkingId());

            parking.map((p) -> {
                schedule.setParking(p);
                return p;
            }).orElseThrow(() -> new IllegalArgumentException("Parking not founded"));

            var response = scheduleRepository.save(schedule);
            return Optional.of(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Schedule> handle(UpdateScheduleCommand command) {
        var result = scheduleRepository.findById(command.scheduleId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Schedule does not exist");
        var scheduleToUpdate = result.get();
        try {
            var updatedSchedule = scheduleRepository.save(scheduleToUpdate.updatedSchedule(command));
            return Optional.of(updatedSchedule);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating schedule: " + e.getMessage());
        }
    }
}
