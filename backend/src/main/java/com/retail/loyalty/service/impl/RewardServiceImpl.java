package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.Points;
import com.retail.loyalty.entity.Reward;
import com.retail.loyalty.repository.RewardRepository;
import com.retail.loyalty.service.PointsService;
import com.retail.loyalty.service.RewardService;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RewardServiceImpl implements RewardService {

    private final RewardRepository rewardRepository;
    private final PointsService pointsService;
    private final R2dbcEntityTemplate template;

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

    @Override
    public Mono<Boolean> redeemReward(String username, Long rewardId) {
        Mono<Reward> rewardMono = rewardRepository.findById(rewardId);
        Mono<Points> userPointsMono = pointsService.getPointsByUsername(username);

        return Mono.zip(rewardMono, userPointsMono)
                .flatMap(tuple -> {
                    Reward reward = tuple.getT1();
                    Points userPoints =  tuple.getT2();

                    if (userPoints.getPoints() >= reward.getPointsRequired()) {
                        userPoints.setPoints(userPoints.getPoints() - reward.getPointsRequired());
                        return pointsService.addPoints(userPoints).thenReturn(true);
                    }
                    return Mono.just(false);
                });
    }
}
