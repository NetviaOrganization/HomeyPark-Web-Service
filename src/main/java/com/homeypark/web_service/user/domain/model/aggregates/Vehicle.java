package com.homeypark.web_service.user.domain.model.aggregates;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.homeypark.web_service.user.domain.model.commands.CreateVehicleCommand;
import com.homeypark.web_service.user.domain.model.commands.UpdateVehicleCommand;
import com.homeypark.web_service.user.domain.model.entities.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "vehicles")

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;
    private String model;
    private String brand;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    public Vehicle(String licensePlate, String model, String brand, User user) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
        this.user = user;
    }


    public Vehicle(CreateVehicleCommand command, User user) {
        this.licensePlate = command.licensePlate();
        this.model = command.model();
        this.brand = command.brand();
        this.user = user;
    }

    public Vehicle updatedVehicle(UpdateVehicleCommand command) {
        this.licensePlate = command.licensePlate();
        this.model = command.model();
        this.brand = command.brand();
        return this;
    }
}