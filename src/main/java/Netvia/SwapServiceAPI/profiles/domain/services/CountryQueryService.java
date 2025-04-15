package Netvia.SwapServiceAPI.profiles.domain.services;

import Netvia.SwapServiceAPI.profiles.domain.model.entities.Country;
import Netvia.SwapServiceAPI.profiles.domain.model.queries.GetCountryByName;

import java.util.Optional;

public interface CountryQueryService {
    Optional<Country> handle(GetCountryByName query);
}
