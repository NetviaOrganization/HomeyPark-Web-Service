package com.homeypark.web_service.user.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.homeypark.web_service.payment.domain.model.entities.Card;
import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import com.homeypark.web_service.user.domain.model.aggregates.Vehicle;
import com.homeypark.web_service.user.domain.model.commands.CreateUserCommand;
import com.homeypark.web_service.user.domain.model.commands.UpdateUserCommand;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime dateCreated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    @JsonManagedReference
    private List<Card> cards = new ArrayList<>();

    public User(String email, Long id, String lastName, String name, String password, LocalDateTime dateCreated) {
        this.id = id;
        this.email = email;
        this.lastName = lastName;
        this.name = name;
        this.password = password;
        this.dateCreated = dateCreated;
        this.vehicles = new ArrayList<>();
    }
    public User(CreateUserCommand command) {
        this.name = command.name();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
        this.vehicles = new ArrayList<>();
        this.dateCreated = LocalDateTime.now();
    }
    public User updatedUser(UpdateUserCommand command) {
        this.name = command.name();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
        return this;
    }
}
