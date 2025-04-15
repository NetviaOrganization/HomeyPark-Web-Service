package Netvia.SwapServiceAPI.iam.interfaces.rest.transform;

import Netvia.SwapServiceAPI.iam.domain.model.commands.SignInCommand;
import Netvia.SwapServiceAPI.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {

  public static SignInCommand toCommandFromResource(SignInResource signInResource) {
    return new SignInCommand(signInResource.username(), signInResource.password());
  }
}
