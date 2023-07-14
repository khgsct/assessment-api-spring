package com.gosoft.assessmentapi.product.viewmodel;

import com.gosoft.assessmentapi.productpicture.ProductPictureResponse;

import java.util.List;
import java.util.UUID;

public record ProductResponse (UUID id, String name, double price, List<ProductPictureResponse> pictures) { }
