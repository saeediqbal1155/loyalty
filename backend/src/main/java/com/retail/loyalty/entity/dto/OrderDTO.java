package com.retail.loyalty.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Long id;
    private Long userId;
    private Long rewardId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

