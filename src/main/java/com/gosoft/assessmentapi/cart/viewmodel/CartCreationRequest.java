package com.gosoft.assessmentapi.cart.viewmodel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CartCreationRequest(@NotNull UUID productId, @Min(1) int quantity) { }
