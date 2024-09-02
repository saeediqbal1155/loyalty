package com.retail.loyalty.entity.mapper;

import com.retail.loyalty.entity.Purchase;
import com.retail.loyalty.entity.dto.PurchaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Mono;

@Mapper
public interface PurchaseMapper {
    PurchaseMapper MAPPER = Mappers.getMapper(PurchaseMapper.class);

    Purchase toEntity(PurchaseDTO purchaseDTO);

    PurchaseDTO toDTO(Purchase purchase);

}
