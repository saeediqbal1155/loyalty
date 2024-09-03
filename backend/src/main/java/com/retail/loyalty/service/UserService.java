package com.retail.loyalty.service;

import com.retail.loyalty.entity.User;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> registerUser(User user);

    Mono<User> findByUsername(String username);

    void uploadCsv(String filePath) throws Exception;
}
