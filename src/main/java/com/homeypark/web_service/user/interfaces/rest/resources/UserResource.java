package com.homeypark.web_service.user.interfaces.rest.resources;

public record UserResource(
        Long id,
        String name,
        String lastName,
        String email,
        String password
) {
}
