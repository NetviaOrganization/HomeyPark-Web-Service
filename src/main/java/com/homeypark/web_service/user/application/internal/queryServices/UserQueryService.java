package com.homeypark.web_service.user.application.internal.queryServices;

import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.domain.model.queries.GetAllUsersQuery;
import com.homeypark.web_service.user.domain.model.queries.GetUserByEmailAndPasswordQuery;
import com.homeypark.web_service.user.domain.model.queries.GetUserByIdQuery;
import com.homeypark.web_service.user.domain.services.IUserQueryService;
import com.homeypark.web_service.user.infrastructure.repositories.jpa.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryService implements IUserQueryService {
    private final IUserRepository userRepository;

    public UserQueryService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query)
    {
        return userRepository.findById(query.userId());
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByEmailAndPasswordQuery query) {
        System.out.println("UserQueryService: handle(GetUserByEmailAndPasswordQuery query)");
        System.out.println(query.email());
        System.out.println(query.password());

        var userList = userRepository.findByEmailAndPassword(query.email(), query.password());

        if (userList.size() == 1) {
            return Optional.of(userList.getFirst());
        }

        return userList.getFirst() == null ? Optional.empty() : Optional.of(userList.getFirst());
    }


}
