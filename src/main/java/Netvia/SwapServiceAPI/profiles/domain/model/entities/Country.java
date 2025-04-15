package Netvia.SwapServiceAPI.profiles.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;

    protected Country() {}

    public Country(String country) {
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country name must not be null or blank");
        }
        this.country = country;
    }
}