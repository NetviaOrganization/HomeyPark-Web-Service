package com.homeypark.web_service.user.application.internal.commandServices;

import com.homeypark.web_service.user.domain.model.commands.CreateUserCommand;
import com.homeypark.web_service.user.domain.model.commands.DeleteUserCommand;
import com.homeypark.web_service.user.domain.model.commands.UpdateUserCommand;
import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.domain.services.IUserCommandService;
import com.homeypark.web_service.user.infrastructure.repositories.jpa.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserCommandService implements IUserCommandService {

    private final IUserRepository userRepository;

    public UserCommandService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> handle(CreateUserCommand command) {
        User user = new User(command);
        user.setDateCreated(LocalDateTime.now());
        try {
            var response = userRepository.save(user);

            return Optional.of(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> handle(UpdateUserCommand command) {
        var result = userRepository.findById(command.userId());
        if (result.isEmpty())
            throw new IllegalArgumentException("User does not exist");
        var userToUpdate = result.get();
        try{
            var updatedUser= userRepository.save(userToUpdate.updatedUser(command));
            return Optional.of(updatedUser);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while updating user: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteUserCommand command){
        userRepository.deleteById(command.userId());
        System.out.println("User Delete");
    }

}
