package Netvia.SwapServiceAPI.iam.interfaces.rest.resources;

import java.util.List;

public record UserResource(Long id, String email, String username, List<String> roles) {
}
