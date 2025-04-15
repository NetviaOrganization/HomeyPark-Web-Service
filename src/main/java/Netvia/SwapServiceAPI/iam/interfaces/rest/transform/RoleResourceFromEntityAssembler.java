package Netvia.SwapServiceAPI.iam.interfaces.rest.transform;

import Netvia.SwapServiceAPI.iam.domain.model.entities.Role;
import Netvia.SwapServiceAPI.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {

  public static RoleResource toResourceFromEntity(Role role) {
    return new RoleResource(role.getId(), role.getStringName());
  }
}
