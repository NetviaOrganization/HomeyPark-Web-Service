package Netvia.SwapServiceAPI.profiles.domain.model.aggregates;

import Netvia.SwapServiceAPI.profiles.domain.model.commands.CreateUserProfileCommand;
import Netvia.SwapServiceAPI.profiles.domain.model.entities.City;
import Netvia.SwapServiceAPI.profiles.domain.model.entities.Country;
import Netvia.SwapServiceAPI.profiles.domain.model.valueobjects.CareerStatus;
import Netvia.SwapServiceAPI.profiles.domain.model.valueobjects.PersonName;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PersonName personName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private CareerStatus careerStatus;

    @ManyToMany
    @JoinTable(
            name = "user_address_profiles",
            joinColumns = {
                    @JoinColumn(name = "city_id", referencedColumnName = "city_id"),
                    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
            },
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private Set<UserProfile> userProfiles = new HashSet<>();

    public UserProfile() {}

    protected UserProfile(CreateUserProfileCommand command) {
        this.city = new City(command.city());
        this.country = new Country(command.country());
        this.personName = new PersonName(command.firstname(), command.lastname());
        this.careerStatus = CareerStatus.valueOf(command.careerStatus());
    }
}