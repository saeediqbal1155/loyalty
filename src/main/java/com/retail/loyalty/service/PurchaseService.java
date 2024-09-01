package com.retail.loyalty.service;

import com.retail.loyalty.entity.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PurchaseService {
    Mono<Purchase> recordPurchase(Purchase purchase);

    Flux<Purchase> getPurchasesByUserId(Long userId);

    Mono<Purchase> getPurchaseDetails(Long purchaseId);
}
