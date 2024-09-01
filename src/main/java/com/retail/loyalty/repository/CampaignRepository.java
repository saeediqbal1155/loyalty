package com.retail.loyalty.repository;

import com.retail.loyalty.entity.Campaign;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CampaignRepository extends ReactiveCrudRepository<Campaign, Long> {
}
