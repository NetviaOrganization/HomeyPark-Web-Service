package Netvia.SwapServiceAPI.profiles.domain.services;

import Netvia.SwapServiceAPI.profiles.domain.model.aggregates.UserProfile;
import Netvia.SwapServiceAPI.profiles.domain.model.commands.CreateUserProfileCommand;

import java.util.Optional;

public interface UserProfileCommandService {
    Optional<UserProfile> handle(CreateUserProfileCommand command);
}
