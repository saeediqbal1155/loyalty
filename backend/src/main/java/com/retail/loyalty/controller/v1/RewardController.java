package com.retail.loyalty.controller.v1;

import com.retail.loyalty.entity.Reward;
import com.retail.loyalty.service.RewardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rewards")
@AllArgsConstructor
public class RewardController extends BaseController {

    private final RewardService rewardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Reward> createReward(@RequestBody Reward reward) {
        return rewardService.createReward(reward);
    }

    @GetMapping
    public Flux<Reward> getAllRewards() {
        return rewardService.getAllRewards();
    }

    @GetMapping("/{id}")
    public Mono<Reward> getRewardById(@PathVariable Long id) {
        return rewardService.getRewardById(id);
    }

    @PutMapping("/{id}")
    public Mono<Reward> updateReward(@PathVariable Long id, @RequestBody Reward reward) {
        return rewardService.updateReward(id, reward);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteReward(@PathVariable Long id) {
        return rewardService.deleteReward(id);
    }
}
