package com.homeypark.web_service.user.domain.model.commands;

public record CreateUserCommand(String name, String lastName, String email, String password) {
}
