package com.retail.loyalty.entity.dto;

import lombok.Data;

@Data
public class PointsDTO {
    private Long id;
    private Long userId;
    private int points;
}

