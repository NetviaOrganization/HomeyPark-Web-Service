package com.homeypark.web_service.user.interfaces.rest.transformers;

import com.homeypark.web_service.user.domain.model.commands.UpdateUserCommand;
import com.homeypark.web_service.user.interfaces.rest.resources.UpdateUserResource;

public class UpdateUserCommandFromResource {
    public static UpdateUserCommand toCommandFromResource(Long userId, UpdateUserResource resource) {
        return new UpdateUserCommand(userId, resource.name(), resource.lastName(), resource.email(), resource.password());
    }
}
