package com.retail.loyalty.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("points")
public class Points {
    @Id
    private Long id;
    private String username;
    private int points;
}
