package Netvia.SwapServiceAPI.profiles.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;

    protected City() {}

    public City(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City name must not be null or blank");
        }
        this.city = city;
    }
}