package com.gosoft.assessmentapi.product.viewmodel;

import com.gosoft.assessmentapi.productpicture.ProductPictureResponse;

import java.util.List;
import java.util.UUID;

public record ProductDetailsResponse(UUID id, String name, double price, String description, List<ProductPictureResponse> pictures) {}
