package com.homeypark.web_service.user.domain.model.commands;

public record UpdateUserCommand(Long userId, String name, String lastName, String email, String password) {
}
