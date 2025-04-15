package Netvia.SwapServiceAPI.iam.domain.services;

import Netvia.SwapServiceAPI.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
  void handle(SeedRolesCommand command);
}
