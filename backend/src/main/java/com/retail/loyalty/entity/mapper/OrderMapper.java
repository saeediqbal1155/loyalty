package com.retail.loyalty.entity.mapper;

import com.retail.loyalty.entity.Order;
import com.retail.loyalty.entity.Purchase;
import com.retail.loyalty.entity.dto.OrderDTO;
import com.retail.loyalty.entity.dto.PurchaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    Order toEntity(OrderDTO orderDTO);

    OrderDTO toDTO(Order purchase);

}
