package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.Points;
import com.retail.loyalty.entity.User;
import com.retail.loyalty.repository.PointsRepository;
import com.retail.loyalty.service.PointsService;
import com.retail.loyalty.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@AllArgsConstructor
public class PointsServiceImpl implements PointsService {
    private final PointsRepository pointsRepository;
    private final UserService userService;

    @Override
    public Mono<Points> getPointsByUsername(String username) {
        Mono<User> userMono = userService.findByUsername(username);
        return pointsRepository.findByUserId(Objects.requireNonNull(userMono.block()).getId());
    }

    @Override
    public Mono<Points> addPoints(Points points) {
        return pointsRepository.save(points);
    }

    @Override
    public Mono<Integer> redeemPoints(Points points) {
        return pointsRepository.redeemPoints(points.getUserId(), points.getPoints());
    }

}