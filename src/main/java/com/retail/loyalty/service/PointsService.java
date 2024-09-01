package com.retail.loyalty.service;

import com.retail.loyalty.entity.Points;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PointsService {
    Flux<Points> getPointsByUserId(Long userId);

    Mono<Points> addPoints(Points points);
}
