package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.Reward;
import com.retail.loyalty.repository.RewardRepository;
import com.retail.loyalty.service.RewardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RewardServiceImpl implements RewardService {

    private final RewardRepository rewardRepository;

    @Override
    public Mono<Reward> createReward(Reward reward) {
        return rewardRepository.save(reward);
    }

    @Override
    public Flux<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }

    @Override
    public Mono<Reward> getRewardById(Long id) {
        return rewardRepository.findById(id);
    }

    @Override
    public Mono<Reward> updateReward(Long id, Reward reward) {
        return rewardRepository.findById(id)
                .flatMap(existingReward -> {
                    existingReward.setName(reward.getName());
                    existingReward.setPointsRequired(reward.getPointsRequired());
                    return rewardRepository.save(existingReward);
                });
    }

    @Override
    public Mono<Void> deleteReward(Long id) {
        return rewardRepository.deleteById(id);
    }
}
