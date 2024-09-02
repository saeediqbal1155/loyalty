package com.retail.loyalty.controller.v1;

import com.retail.loyalty.entity.Points;
import com.retail.loyalty.service.PointsService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/points")
public class PointsController extends BaseController {
    private final PointsService pointsService;

    public PointsController(PointsService pointsService) {
        this.pointsService = pointsService;
    }

    @GetMapping("/{username}")
    public Mono<Points> getPoints(@PathVariable String username) {
        return pointsService.getPointsByUsername(username);
    }

    @PostMapping("/add")
    public Mono<Points> addPoints(@RequestBody Points points) {
        return pointsService.addPoints(points);
    }

    @PostMapping("/redeem")
    public Mono<Integer> redeemPoints(@RequestBody Points points) {
        return pointsService.redeemPoints(points);
    }


}

