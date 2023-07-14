package com.gosoft.assessmentapi.productpicture;

import com.gosoft.assessmentapi.file.File;
import com.gosoft.assessmentapi.product.domain.Product;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProductPicture {
    @EmbeddedId
    private ProductPictureKey id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @MapsId("productId")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", nullable = false)
    @MapsId("fileId")
    private File file;
}
