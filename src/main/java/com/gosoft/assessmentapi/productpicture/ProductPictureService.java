package com.gosoft.assessmentapi.productpicture;

import com.gosoft.assessmentapi.file.FileService;
import com.gosoft.assessmentapi.product.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProductPictureService {
    private final FileService fileService;
    private final ProductPictureRepository productImageRepository;

    public ProductPictureService(FileService imageService, ProductPictureRepository productImageRepository) {
        this.fileService = imageService;
        this.productImageRepository = productImageRepository;
    }

    public ProductPicture AddProductPicture(Product product, MultipartFile file) throws IOException {
        var picture = fileService.uploadPicture(file);
        return productImageRepository.save(ProductPicture.builder()
                .id(ProductPictureKey.builder()
                        .productId(product.getId())
                        .fileId(picture.getId())
                        .build())
                .product(product)
                .file(picture)
                .build());
    }
}
