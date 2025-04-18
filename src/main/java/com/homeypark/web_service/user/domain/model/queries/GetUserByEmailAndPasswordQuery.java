package com.homeypark.web_service.user.domain.model.queries;

public record GetUserByEmailAndPasswordQuery (String email, String password) {
}
