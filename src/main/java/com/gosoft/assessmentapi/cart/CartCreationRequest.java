package com.gosoft.assessmentapi.cart;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CartCreationRequest(@NotNull UUID productId, @Min(1) int quantity) { }
