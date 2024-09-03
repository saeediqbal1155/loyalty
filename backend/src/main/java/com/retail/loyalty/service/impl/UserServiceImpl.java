package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.User;
import com.retail.loyalty.repository.UserRepository;
import com.retail.loyalty.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final R2dbcEntityTemplate template;
    private final JobLauncher jobLauncher;
    private final Job job;

    @Override
    public Mono<User> registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void uploadCsv(String filePath) throws Exception {
        // Launch the Spring Batch job to process the CSV file
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("filePath", filePath)
                .toJobParameters();
        jobLauncher.run(job, jobParameters);
    }
}