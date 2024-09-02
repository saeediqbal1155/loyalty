package com.retail.loyalty.entity.mapper;

import com.retail.loyalty.entity.Campaign;
import com.retail.loyalty.entity.dto.CampaignDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-02T08:28:44+0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
public class CampaignMapperImpl implements CampaignMapper {

    @Override
    public Campaign toEntity(CampaignDTO campaignDTO) {
        if ( campaignDTO == null ) {
            return null;
        }

        Campaign campaign = new Campaign();

        campaign.setId( campaignDTO.getId() );
        campaign.setName( campaignDTO.getName() );
        campaign.setActive( campaignDTO.isActive() );
        campaign.setStartDate( campaignDTO.getStartDate() );
        campaign.setEndDate( campaignDTO.getEndDate() );

        return campaign;
    }

    @Override
    public CampaignDTO toDTO(Campaign purchase) {
        if ( purchase == null ) {
            return null;
        }

        CampaignDTO campaignDTO = new CampaignDTO();

        campaignDTO.setId( purchase.getId() );
        campaignDTO.setName( purchase.getName() );
        campaignDTO.setActive( purchase.isActive() );
        campaignDTO.setStartDate( purchase.getStartDate() );
        campaignDTO.setEndDate( purchase.getEndDate() );

        return campaignDTO;
    }
}
