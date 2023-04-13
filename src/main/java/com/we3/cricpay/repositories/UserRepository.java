package com.we3.cricpay.repositories;

import com.we3.cricpay.models.entities.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
}
