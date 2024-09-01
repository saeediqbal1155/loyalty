package com.retail.loyalty.repository;

import com.retail.loyalty.entity.Campaign;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CampaignRepository extends ReactiveCrudRepository<Campaign, Long> {
    Flux<Campaign> findByActiveTrue();
}
