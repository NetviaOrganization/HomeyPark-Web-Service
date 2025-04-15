package Netvia.SwapServiceAPI.profiles.domain.model.commands;

public record CreateUserProfileCommand(String firstname, String lastname, String country, String city, String careerStatus) {
}
