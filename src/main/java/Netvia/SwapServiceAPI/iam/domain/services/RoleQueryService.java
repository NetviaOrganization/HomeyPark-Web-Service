package Netvia.SwapServiceAPI.iam.domain.services;

import Netvia.SwapServiceAPI.iam.domain.model.entities.Role;
import Netvia.SwapServiceAPI.iam.domain.model.queries.GetAllRolesQuery;
import Netvia.SwapServiceAPI.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
  List<Role> handle(GetAllRolesQuery query);
  Optional<Role> handle(GetRoleByNameQuery query);
}
