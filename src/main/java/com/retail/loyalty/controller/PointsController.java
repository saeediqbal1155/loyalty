package com.retail.loyalty.controller;

import com.retail.loyalty.entity.Points;
import com.retail.loyalty.service.PointsService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/points")
public class PointsController {
    private final PointsService pointsService;

    public PointsController(PointsService pointsService) {
        this.pointsService = pointsService;
    }

    @GetMapping("/{userId}")
    public Flux<Points> getPoints(@PathVariable Long userId) {
        return pointsService.getPointsByUserId(userId);
    }

    @PostMapping("/add")
    public Mono<Points> addPoints(@RequestBody Points points) {
        return pointsService.addPoints(points);
    }

    @PostMapping("/redeem")
    public Mono<Integer> redeemPoints(@RequestBody Points points) {
        return pointsService.redeemPoints(points);
    }

    @GetMapping("/history/{userId}")
    public Flux<Points> getTransactionHistory(@PathVariable Long userId) {
        return pointsService.getTransactionHistory(userId);
    }

}

