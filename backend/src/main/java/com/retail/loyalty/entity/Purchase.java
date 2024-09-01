package com.retail.loyalty.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("purchases")
public class Purchase {
    @Id
    private Long id;
    private Long userId;
    private Double amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
