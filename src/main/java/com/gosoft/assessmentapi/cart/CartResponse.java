package com.gosoft.assessmentapi.cart;

import java.util.UUID;

public record CartResponse (UUID id, String productName, double productPrice, int quantity, double totalPrice) { }
