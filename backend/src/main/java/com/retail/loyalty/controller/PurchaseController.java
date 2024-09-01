package com.retail.loyalty.controller;

import com.retail.loyalty.entity.Purchase;
import com.retail.loyalty.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/purchases")
@AllArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Purchase> recordPurchase(@RequestBody Purchase purchase) {
        return purchaseService.recordPurchase(purchase);
    }

    @GetMapping("/{userId}")
    public Flux<Purchase> getPurchasesByUserId(@PathVariable Long userId) {
        return purchaseService.getPurchasesByUserId(userId);
    }

    @GetMapping("/details/{purchaseId}")
    public Mono<Purchase> getPurchaseDetails(@PathVariable Long purchaseId) {
        return purchaseService.getPurchaseDetails(purchaseId);
    }
}
