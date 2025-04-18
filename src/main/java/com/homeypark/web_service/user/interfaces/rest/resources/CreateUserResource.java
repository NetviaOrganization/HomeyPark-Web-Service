package com.homeypark.web_service.user.interfaces.rest.resources;

public record CreateUserResource(
        String name,
        String lastName,
        String email,
        String password
) {
}
