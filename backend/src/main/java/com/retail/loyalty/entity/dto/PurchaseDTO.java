package com.retail.loyalty.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PurchaseDTO {
    private Long userId;
    private Double amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

