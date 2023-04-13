package com.we3.cricpay.controllers;

import com.we3.cricpay.models.dtos.CreateUserDto;
import com.we3.cricpay.models.dtos.UserDto;
import com.we3.cricpay.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Flux<UserDto>> getUsers() {
        Flux<UserDto> foundUsers = this.userService.getUsers();
        return new ResponseEntity<>(foundUsers, HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<Mono<UserDto>> getUsersByID(@PathVariable() Integer userId) {
        Mono<UserDto> foundUser = this.userService.getUserById(userId);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mono<UserDto>> createUser(@RequestBody() CreateUserDto body) {
        Mono<UserDto> createdUser = this.userService.createUser(body);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<Mono<UserDto>> updateUser(@PathVariable() Integer userId, @RequestBody() UserDto body) {
        Mono<UserDto> updatedUser = this.userService.updateUser(userId, body);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Mono<UserDto>> deleteUser(@PathVariable() Integer userId) {
        Mono<UserDto> deletedUser = this.userService.deleteUser(userId);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }
}
