package com.homeypark.web_service.user.interfaces.rest;


import com.homeypark.web_service.user.application.internal.commandServices.UserCommandService;
import com.homeypark.web_service.user.application.internal.queryServices.UserQueryService;
import com.homeypark.web_service.user.domain.model.commands.CreateUserCommand;
import com.homeypark.web_service.user.domain.model.commands.DeleteUserCommand;
import com.homeypark.web_service.user.domain.model.entities.User;
import com.homeypark.web_service.user.domain.model.queries.GetAllUsersQuery;
import com.homeypark.web_service.user.domain.model.queries.GetUserByEmailAndPasswordQuery;
import com.homeypark.web_service.user.domain.model.queries.GetUserByIdQuery;
import com.homeypark.web_service.user.interfaces.rest.resources.CreateUserResource;
import com.homeypark.web_service.user.interfaces.rest.resources.UpdateUserResource;
import com.homeypark.web_service.user.interfaces.rest.transformers.CreateUserCommandFromResourceAssembler;
import com.homeypark.web_service.user.interfaces.rest.transformers.UpdateUserCommandFromResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<User> getUserByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        var getUserByEmailAndPasswordQuery = new GetUserByEmailAndPasswordQuery(email, password);

        var user = userQueryService.handle(getUserByEmailAndPasswordQuery);

        return user.map(u -> new ResponseEntity<>(u, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        var getUserByIdQuery = new GetUserByIdQuery(id);

        var user = userQueryService.handle(getUserByIdQuery);

        return user.map(u -> new ResponseEntity<>(u, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserResource createUserResource) {
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(createUserResource);

        var user = userCommandService.handle(createUserCommand);

        return user.map(u -> new ResponseEntity<>(u, HttpStatus.CREATED)).orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UpdateUserResource updateUserResource) {
        var updateUserCommand = UpdateUserCommandFromResource.toCommandFromResource(id, updateUserResource);
        var updatedUser = userCommandService.handle(updateUserCommand);
        return updatedUser.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        var deleteUserCommand = new DeleteUserCommand(id);
        userCommandService.handle(deleteUserCommand);
        return ResponseEntity.ok("User with given id successfully deleted ");
    }

}
