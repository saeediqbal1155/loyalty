package com.retail.loyalty.service;

import com.retail.loyalty.entity.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> registerUser(User user);

    Mono<User> findByUsername(String username);
}
