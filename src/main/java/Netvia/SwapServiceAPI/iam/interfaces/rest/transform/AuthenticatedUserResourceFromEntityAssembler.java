package Netvia.SwapServiceAPI.iam.interfaces.rest.transform;

import Netvia.SwapServiceAPI.iam.domain.model.aggregates.User;
import Netvia.SwapServiceAPI.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {

  public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
    return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
  }
}
