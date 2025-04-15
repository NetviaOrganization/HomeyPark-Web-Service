package Netvia.SwapServiceAPI.iam.domain.model.commands;

import Netvia.SwapServiceAPI.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
