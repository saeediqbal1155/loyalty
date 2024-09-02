package com.retail.loyalty.entity.mapper;

import com.retail.loyalty.entity.Reward;
import com.retail.loyalty.entity.dto.RewardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RewardMapper {
    RewardMapper MAPPER = Mappers.getMapper(RewardMapper.class);

    Reward toEntity(RewardDTO rewardDTO);

    RewardDTO toDTO(Reward purchase);

}
