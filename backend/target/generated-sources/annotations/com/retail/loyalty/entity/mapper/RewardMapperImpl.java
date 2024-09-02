package com.retail.loyalty.entity.mapper;

import com.retail.loyalty.entity.Reward;
import com.retail.loyalty.entity.dto.RewardDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-02T08:28:44+0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
public class RewardMapperImpl implements RewardMapper {

    @Override
    public Reward toEntity(RewardDTO rewardDTO) {
        if ( rewardDTO == null ) {
            return null;
        }

        Reward reward = new Reward();

        reward.setName( rewardDTO.getName() );
        reward.setPointsRequired( rewardDTO.getPointsRequired() );

        return reward;
    }

    @Override
    public RewardDTO toDTO(Reward purchase) {
        if ( purchase == null ) {
            return null;
        }

        RewardDTO rewardDTO = new RewardDTO();

        rewardDTO.setName( purchase.getName() );
        rewardDTO.setPointsRequired( purchase.getPointsRequired() );

        return rewardDTO;
    }
}
