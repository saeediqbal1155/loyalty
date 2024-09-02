package com.retail.loyalty.controller.v1;

import com.retail.loyalty.entity.dto.PurchaseDTO;
import com.retail.loyalty.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Purchases")
@AllArgsConstructor
public class PurchaseController extends BaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PurchaseDTO> recordPurchase(@RequestBody PurchaseDTO purchaseDTO) {
        return purchaseService.recordPurchase(purchaseDTO);
    }

    @GetMapping("/{userId}")
    public Flux<PurchaseDTO> getPurchasesByUserId(@PathVariable Long userId) {
        return purchaseService.getPurchasesByUserId(userId);
    }

    @GetMapping("/details/{PurchaseId}")
    public Mono<PurchaseDTO> getPurchaseDetails(@PathVariable Long purchaseId) {
        return purchaseService.getPurchaseDetails(purchaseId);
    }
}
