package com.homeypark.web_service.user.interfaces.rest.transformers;

import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}
