package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.Purchase;
import com.retail.loyalty.repository.PurchaseRepository;
import com.retail.loyalty.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Override
    public Mono<Purchase> recordPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public Flux<Purchase> getPurchasesByUserId(Long userId) {
        return purchaseRepository.findByUserId(userId);
    }

    @Override
    public Mono<Purchase> getPurchaseDetails(Long purchaseId) {
        return purchaseRepository.findById(purchaseId);
    }
}
