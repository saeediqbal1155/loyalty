package com.retail.loyalty.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("rewards")
public class Reward {
    @Id
    private Long id;
    private String name;
    private int pointsRequired;
}
