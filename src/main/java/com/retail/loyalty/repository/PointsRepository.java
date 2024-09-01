package com.retail.loyalty.repository;

import com.retail.loyalty.entity.Points;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PointsRepository extends ReactiveCrudRepository<Points, Long> {
    Flux<Points> findByUserId(Long userId);
}
