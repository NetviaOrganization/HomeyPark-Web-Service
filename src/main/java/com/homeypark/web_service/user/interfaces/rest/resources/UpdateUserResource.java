package com.homeypark.web_service.user.interfaces.rest.resources;

public record UpdateUserResource(
        String name,
        String lastName,
        String email,
        String password
) {
}
