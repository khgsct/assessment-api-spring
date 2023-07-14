package com.gosoft.assessmentapi.cart.viewmodel;

import java.util.UUID;

public record CartResponse (UUID id, UUID productId, String productName, double productPrice, int quantity, double totalPrice) { }
