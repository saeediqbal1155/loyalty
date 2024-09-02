package com.retail.loyalty.service;

import com.retail.loyalty.entity.Points;
import reactor.core.publisher.Mono;

public interface PointsService {
    Mono<Points> getPointsByUsername(String username);

    Mono<Points> addPoints(Points points);

    Mono<Integer> redeemPoints(Points points);

}
