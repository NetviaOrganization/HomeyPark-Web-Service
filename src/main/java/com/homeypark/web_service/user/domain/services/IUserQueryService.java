package com.homeypark.web_service.user.domain.services;

import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.domain.model.queries.GetAllUsersQuery;
import com.homeypark.web_service.user.domain.model.queries.GetUserByEmailAndPasswordQuery;
import com.homeypark.web_service.user.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface IUserQueryService {
    Optional<User> handle(GetUserByIdQuery query);

    List<User> handle(GetAllUsersQuery query);

    Optional<User> handle(GetUserByEmailAndPasswordQuery query);
}
