package com.gosoft.assessmentapi.productpicture;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductPictureMapper {
    ProductPictureMapper MAPPER = Mappers.getMapper(ProductPictureMapper.class);

    ProductPictureResponse toResponse(ProductPicture productPicture);
}
