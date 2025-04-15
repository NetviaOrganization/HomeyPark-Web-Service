package Netvia.SwapServiceAPI.iam.interfaces.rest.transform;

import Netvia.SwapServiceAPI.iam.domain.model.aggregates.User;
import Netvia.SwapServiceAPI.iam.domain.model.entities.Role;
import Netvia.SwapServiceAPI.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {

  public static UserResource toResourceFromEntity(User user) {
    var roles = user.getRoles().stream()
        .map(Role::getStringName)
        .toList();
    return new UserResource(user.getId(), user.getEmail(), user.getUsername(), roles);
  }
}
