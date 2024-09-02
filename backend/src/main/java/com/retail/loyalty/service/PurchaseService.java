package com.retail.loyalty.service;

import com.retail.loyalty.entity.Purchase;
import com.retail.loyalty.entity.dto.PurchaseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PurchaseService {
    Mono<PurchaseDTO> recordPurchase(PurchaseDTO purchase);

    Flux<PurchaseDTO> getPurchasesByUserId(Long userId);

    Mono<PurchaseDTO> getPurchaseDetails(Long purchaseId);
}
