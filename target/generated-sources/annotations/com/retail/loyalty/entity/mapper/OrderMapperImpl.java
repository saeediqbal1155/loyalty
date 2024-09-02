package com.retail.loyalty.entity.mapper;

import com.retail.loyalty.entity.Order;
import com.retail.loyalty.entity.dto.OrderDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-02T10:14:24+0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDTO.getId() );
        order.setUserId( orderDTO.getUserId() );
        order.setRewardId( orderDTO.getRewardId() );
        order.setStatus( orderDTO.getStatus() );
        order.setCreatedAt( orderDTO.getCreatedAt() );
        order.setUpdatedAt( orderDTO.getUpdatedAt() );

        return order;
    }

    @Override
    public OrderDTO toDTO(Order purchase) {
        if ( purchase == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( purchase.getId() );
        orderDTO.setUserId( purchase.getUserId() );
        orderDTO.setRewardId( purchase.getRewardId() );
        orderDTO.setStatus( purchase.getStatus() );
        orderDTO.setCreatedAt( purchase.getCreatedAt() );
        orderDTO.setUpdatedAt( purchase.getUpdatedAt() );

        return orderDTO;
    }
}
