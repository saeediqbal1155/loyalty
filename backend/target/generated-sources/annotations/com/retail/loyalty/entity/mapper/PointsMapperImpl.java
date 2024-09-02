package com.retail.loyalty.entity.mapper;

import com.retail.loyalty.entity.Points;
import com.retail.loyalty.entity.dto.PointsDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-02T08:28:44+0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
public class PointsMapperImpl implements PointsMapper {

    @Override
    public Points toEntity(PointsDTO pointsDTO) {
        if ( pointsDTO == null ) {
            return null;
        }

        Points points = new Points();

        points.setId( pointsDTO.getId() );
        points.setUserId( pointsDTO.getUserId() );
        points.setPoints( pointsDTO.getPoints() );

        return points;
    }

    @Override
    public PointsDTO toDTO(Points purchase) {
        if ( purchase == null ) {
            return null;
        }

        PointsDTO pointsDTO = new PointsDTO();

        pointsDTO.setId( purchase.getId() );
        pointsDTO.setUserId( purchase.getUserId() );
        pointsDTO.setPoints( purchase.getPoints() );

        return pointsDTO;
    }
}
