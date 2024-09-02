package com.retail.loyalty.entity.mapper;

import com.retail.loyalty.entity.Campaign;
import com.retail.loyalty.entity.Purchase;
import com.retail.loyalty.entity.dto.CampaignDTO;
import com.retail.loyalty.entity.dto.PurchaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CampaignMapper {
    CampaignMapper MAPPER = Mappers.getMapper(CampaignMapper.class);

    Campaign toEntity(CampaignDTO campaignDTO);

    CampaignDTO toDTO(Campaign purchase);

}
