package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.Purchase;
import com.retail.loyalty.entity.dto.PurchaseDTO;
import com.retail.loyalty.entity.mapper.PurchaseMapper;
import com.retail.loyalty.repository.PurchaseRepository;
import com.retail.loyalty.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final R2dbcEntityTemplate template;

    @Override
    public Mono<PurchaseDTO> recordPurchase(PurchaseDTO purchaseDTO) {
        Purchase purchase = PurchaseMapper.MAPPER.toEntity(purchaseDTO);
        Mono<Purchase> purchase1 = purchaseRepository.save(purchase);
        return purchase1.map(PurchaseMapper.MAPPER::toDTO);
    }

    @Override
    public Flux<PurchaseDTO> getPurchasesByUserId(Long userId) {
        return purchaseRepository.findByUserId(userId).map(PurchaseMapper.MAPPER::toDTO);
    }

    @Override
    public Mono<PurchaseDTO> getPurchaseDetails(Long purchaseId) {
        return purchaseRepository.findById(purchaseId).map(PurchaseMapper.MAPPER::toDTO);
    }
}
