package com.gosoft.assessmentapi.productpicture;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor()
@AllArgsConstructor
@Builder
@Embeddable
public class ProductPictureKey implements Serializable {
    @Column(name = "product_id")
    private UUID productId;
    @Column(name = "file_id")
    private UUID fileId;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
