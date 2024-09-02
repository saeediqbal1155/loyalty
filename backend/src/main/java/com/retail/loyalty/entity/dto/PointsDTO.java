package com.retail.loyalty.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PointsDTO {
    private Long id;
    private Long userId;
    private int points;
}

