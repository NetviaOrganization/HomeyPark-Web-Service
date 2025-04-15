package Netvia.SwapServiceAPI.profiles.domain.services;

import Netvia.SwapServiceAPI.profiles.domain.model.entities.City;
import Netvia.SwapServiceAPI.profiles.domain.model.queries.GetCityByName;

import java.util.Optional;

public interface CityQueryService {
    Optional<City> handle(GetCityByName query);
}
