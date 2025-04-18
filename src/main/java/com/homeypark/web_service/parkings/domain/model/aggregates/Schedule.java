package com.homeypark.web_service.parkings.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
import com.homeypark.web_service.parkings.domain.model.commands.CreateScheduleCommand;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateScheduleCommand;
import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.user.domain.model.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "parking_id")
    @JsonBackReference
    private Parking parking;

    private String day;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public Schedule(CreateScheduleCommand command){
        this.day = command.day();
        this.startTime = command.startTime();
        this.endTime = command.endTime();
    }
    public Schedule updatedSchedule(UpdateScheduleCommand command){
        this.day = command.day();
        this.startTime = command.startTime();
        this.endTime = command.endTime();
        return this;
    }

}
