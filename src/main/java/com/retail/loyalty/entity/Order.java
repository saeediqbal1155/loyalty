package com.retail.loyalty.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("orders")
public class Order {
    @Id
    private Long id;
    private Long userId;
    private Long rewardId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
