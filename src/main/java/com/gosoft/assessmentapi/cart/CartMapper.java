package com.gosoft.assessmentapi.cart;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CartMapper {

    CartMapper MAPPER = Mappers.getMapper(CartMapper.class);

    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.price", target = "productPrice")
    CartResponse toResponse(Cart userCart);

    List<CartResponse> toResponse(Iterable<Cart> userCart);
    CartSummaryResponse toResponse(CartSummary userCart);
}
