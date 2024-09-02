package com.retail.loyalty.entity.mapper;

import com.retail.loyalty.entity.Purchase;
import com.retail.loyalty.entity.dto.PurchaseDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-02T08:30:46+0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
public class PurchaseMapperImpl implements PurchaseMapper {

    @Override
    public Purchase toEntity(PurchaseDTO purchaseDTO) {
        if ( purchaseDTO == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        purchase.setUserId( purchaseDTO.getUserId() );
        purchase.setAmount( purchaseDTO.getAmount() );
        purchase.setCreatedAt( purchaseDTO.getCreatedAt() );
        purchase.setUpdatedAt( purchaseDTO.getUpdatedAt() );

        return purchase;
    }

    @Override
    public PurchaseDTO toDTO(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        PurchaseDTO purchaseDTO = new PurchaseDTO();

        purchaseDTO.setUserId( purchase.getUserId() );
        purchaseDTO.setAmount( purchase.getAmount() );
        purchaseDTO.setCreatedAt( purchase.getCreatedAt() );
        purchaseDTO.setUpdatedAt( purchase.getUpdatedAt() );

        return purchaseDTO;
    }
}
