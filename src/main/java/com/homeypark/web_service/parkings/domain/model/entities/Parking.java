package com.homeypark.web_service.parkings.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.domain.model.aggregates.Schedule;
import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
import com.homeypark.web_service.parkings.domain.model.commands.UpdateParkingCommand;
import com.homeypark.web_service.user.domain.model.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "parkings")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Double width;
    public Double length;
    public Double height;
    public Double price;
    public String phone;
    public Integer space;

    @Column(columnDefinition = "TEXT")
    public String description;

    @OneToOne(mappedBy = "parking", cascade = CascadeType.ALL, optional = false)
    @JsonManagedReference
    private Location location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parking")
    @JsonManagedReference
    private List<Schedule> schedules = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "user_id", insertable = true, updatable = true)
    private User user;

    public Parking(CreateParkingCommand command) {
        this.width = command.width();
        this.length = command.length();
        this.height = command.height();
        this.price = command.price();
        this.phone = command.phone();
        this.space = command.space();
        this.description = command.description();

        //Location
        this.location = new Location();
        this.location.setAddress(command.address());
        this.location.setNumDirection(command.numDirection());
        this.location.setStreet(command.street());
        this.location.setDistrict(command.district());
        this.location.setCity(command.city());
        this.location.setLatitude(command.latitude());
        this.location.setLongitude(command.longitude());

        this.location.setParking(this);

    }

    public void updateParking(UpdateParkingCommand command){
        this.width = command.width();
        this.length = command.length();
        this.height = command.height();
        this.price = command.price();
        this.phone = command.phone();
        this.space = command.space();
        this.description = command.description();

        this.location.setAddress(command.address());
        this.location.setNumDirection(command.numDirection());
        this.location.setStreet(command.street());
        this.location.setDistrict(command.district());
        this.location.setCity(command.city());
        this.location.setLatitude(command.latitude());
        this.location.setLongitude(command.longitude());

        this.location.setParking(this);
    }
    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", price=" + price +
                ", phone='" + phone + '\'' +
                ", space=" + space +
                ", description='" + description + '\'' +
                ", location=" + (location != null ? location.toString() : "null") +
                ", schedules=" + schedules +
                ", user=" + (user != null ? user.getId() : "null") +
                '}';
    }
}
