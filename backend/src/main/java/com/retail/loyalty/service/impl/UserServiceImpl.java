package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.User;
import com.retail.loyalty.repository.UserRepository;
import com.retail.loyalty.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Mono<User> registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

