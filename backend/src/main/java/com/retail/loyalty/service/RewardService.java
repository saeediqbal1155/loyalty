package com.retail.loyalty.service;

import com.retail.loyalty.entity.Reward;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RewardService {
    Mono<Reward> createReward(Reward reward);

    Flux<Reward> getAllRewards();

    Mono<Reward> getRewardById(Long id);

    Mono<Reward> updateReward(Long id, Reward reward);

    Mono<Void> deleteReward(Long id);

    Mono<Boolean> redeemReward(String username, Long rewardId);
}
