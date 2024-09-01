package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.Points;
import com.retail.loyalty.repository.PointsRepository;
import com.retail.loyalty.service.PointsService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PointsServiceImpl implements PointsService {
    private final PointsRepository pointsRepository;

    public PointsServiceImpl(PointsRepository pointsRepository) {
        this.pointsRepository = pointsRepository;
    }

    @Override
    public Flux<Points> getPointsByUserId(Long userId) {
        return pointsRepository.findByUserId(userId);
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