package com.gosoft.assessmentapi.cart;

import com.gosoft.assessmentapi.user.UserLoginMapper;
import org.mapstruct.Mapper;
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

    List<CartResponse> toResponse(Iterable<Cart> userCart);
}
