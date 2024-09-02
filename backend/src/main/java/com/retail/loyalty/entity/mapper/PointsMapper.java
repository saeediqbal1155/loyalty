package com.retail.loyalty.entity.mapper;

import com.retail.loyalty.entity.Points;
import com.retail.loyalty.entity.Purchase;
import com.retail.loyalty.entity.dto.PointsDTO;
import com.retail.loyalty.entity.dto.PurchaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PointsMapper {
    PointsMapper MAPPER = Mappers.getMapper(PointsMapper.class);

    Points toEntity(PointsDTO pointsDTO);

    PointsDTO toDTO(Points purchase);

}
