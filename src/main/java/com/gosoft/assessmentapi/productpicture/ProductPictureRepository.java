package com.gosoft.assessmentapi.productpicture;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductPictureRepository extends CrudRepository<ProductPicture, UUID> {
}
