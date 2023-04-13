package com.we3.cricpay.service;

import com.we3.cricpay.models.dtos.CreateUserDto;
import com.we3.cricpay.models.dtos.UserDto;
import com.we3.cricpay.models.entities.User;
import com.we3.cricpay.models.mappers.UserMapper;
import com.we3.cricpay.repositories.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Flux<UserDto> getUsers() {
        return this.userRepository.findAll().map(userMapper::toDto);
    }

    public Mono<UserDto> getUserById(Integer userId) {
        return this.userRepository.findById(userId).map(userMapper::toDto);
    }

    public Mono<UserDto> createUser(CreateUserDto body) {
        UserDto user = new UserDto()
                .setName(body.getName())
                .setUsername(body.getUsername())
                .setEmail(body.getEmail())
                .setPhone(body.getPhone())
                .setStatus(body.getStatus());

        return this.userRepository.save(userMapper.toEntity(user)).map(userMapper::toDto);
    }

    public Mono<UserDto> updateUser(Integer userId, UserDto body) {
        return this.userRepository.findById(userId).flatMap(existingUser -> {
            existingUser
                    .setName(body.getName())
                    .setUsername(body.getUsername())
                    .setEmail(body.getEmail())
                    .setPhone(body.getPhone())
                    .setStatus(body.getStatus());

            return this.userRepository.save(existingUser);
        }).map(userMapper::toDto);
    }

    public Mono<UserDto> deleteUser(Integer userId) {
        return this.userRepository.findById(userId)
                .flatMap(existingUser -> this.userRepository
                        .delete(existingUser)
                        .then(Mono.just(userMapper.toDto(existingUser)))
                );
    }
}
