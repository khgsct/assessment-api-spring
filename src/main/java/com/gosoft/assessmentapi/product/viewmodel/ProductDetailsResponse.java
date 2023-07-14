package com.gosoft.assessmentapi.product.viewmodel;

import java.util.UUID;

public record ProductDetailsResponse(UUID id, String name, double price, String description) {}
