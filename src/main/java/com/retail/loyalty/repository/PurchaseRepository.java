package com.retail.loyalty.repository;

import com.retail.loyalty.entity.Purchase;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PurchaseRepository extends ReactiveCrudRepository<Purchase, Long> {
    Flux<Purchase> findByUserId(Long userId);
}

