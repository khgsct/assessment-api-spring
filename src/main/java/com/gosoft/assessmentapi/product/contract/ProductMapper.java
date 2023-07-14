package com.gosoft.assessmentapi.product.contract;

import com.gosoft.assessmentapi.product.domain.Product;
import com.gosoft.assessmentapi.product.viewmodel.ProductDetailsResponse;
import com.gosoft.assessmentapi.product.viewmodel.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    List<ProductResponse> toResponse(Iterable<Product> products);
    ProductResponse toResponse(Product products);
    ProductDetailsResponse toDetailsResponse(Product product);
}
