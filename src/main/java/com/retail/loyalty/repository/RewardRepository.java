package com.retail.loyalty.repository;

import com.retail.loyalty.entity.Reward;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RewardRepository extends ReactiveCrudRepository<Reward, Long> {
}
