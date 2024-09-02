package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.User;
import com.retail.loyalty.repository.UserRepository;
import com.retail.loyalty.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public void uploadCsv(MultipartFile file) throws Exception {
        List<User> users = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String headerLine = br.readLine();
            if (headerLine == null) {
                throw new Exception("CSV file is empty");
            }

            String[] headers = headerLine.split(",");
            String firstColumn = headers[0].trim().toLowerCase();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                User user = new User();

                if (firstColumn.equals("username")) {
                    user.setUsername(values[0].trim());
                    user.setRole(values[1].trim());
                } else if (firstColumn.equals("role")) {
                    user.setRole(values[0].trim());
                    user.setUsername(values[1].trim());
                } else {
                    throw new Exception("Invalid CSV format");
                }

                users.add(user);
            }
        }

        userRepository.saveAll(users);
    }
}

