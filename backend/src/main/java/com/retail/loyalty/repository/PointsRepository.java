package com.retail.loyalty.repository;

import com.retail.loyalty.entity.Points;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PointsRepository extends ReactiveCrudRepository<Points, Long> {
    Mono<Points> findByUsername(String username);
    @Query("UPDATE points SET balance = balance - :points WHERE user_id = :userId AND balance >= :points")
    Mono<Integer> redeemPoints(@Param("username") String username, @Param("points") int points);
}
