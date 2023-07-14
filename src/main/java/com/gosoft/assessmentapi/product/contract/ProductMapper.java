package com.gosoft.assessmentapi.product.contract;

import com.gosoft.assessmentapi.file.File;
import com.gosoft.assessmentapi.file.FileResponse;
import com.gosoft.assessmentapi.product.domain.Product;
import com.gosoft.assessmentapi.product.viewmodel.ProductDetailsResponse;
import com.gosoft.assessmentapi.product.viewmodel.ProductResponse;
import com.gosoft.assessmentapi.productpicture.ProductPicture;
import com.gosoft.assessmentapi.productpicture.ProductPictureResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    List<ProductResponse> toResponse(Iterable<Product> products);
    ProductResponse toResponse(Product products);
    FileResponse toResponse(File file);
    List<ProductPictureResponse> toResponse(Set<ProductPicture> pictures);
    ProductDetailsResponse toDetailsResponse(Product product);
}
