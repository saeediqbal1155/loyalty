package com.retail.loyalty.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CampaignDTO {
    private Long id;
    private String name;
    private boolean active;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}

