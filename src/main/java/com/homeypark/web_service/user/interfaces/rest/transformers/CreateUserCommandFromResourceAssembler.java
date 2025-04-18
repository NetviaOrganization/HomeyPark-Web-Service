package com.homeypark.web_service.user.interfaces.rest.transformers;

import com.homeypark.web_service.user.domain.model.commands.CreateUserCommand;
import com.homeypark.web_service.user.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.name(), resource.lastName(), resource.email(), resource.password());
    }
}
