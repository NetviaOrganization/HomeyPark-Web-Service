package Netvia.SwapServiceAPI.profiles.domain.services;

import Netvia.SwapServiceAPI.profiles.domain.model.aggregates.UserProfile;
import Netvia.SwapServiceAPI.profiles.domain.model.queries.GetUserProfileByIdQuery;

import java.util.Optional;

public interface UserProfileQueryService {
    Optional<UserProfile> handle(GetUserProfileByIdQuery query);
}
