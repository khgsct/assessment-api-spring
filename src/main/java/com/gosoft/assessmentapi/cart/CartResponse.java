package com.gosoft.assessmentapi.cart;

import java.util.UUID;

public record CartResponse (UUID cartId, String productName, double productPrice) { }
