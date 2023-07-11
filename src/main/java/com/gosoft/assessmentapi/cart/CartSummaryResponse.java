package com.gosoft.assessmentapi.cart;

import java.util.List;

public record CartSummaryResponse(List<CartResponse> cartDetails, double totalPrice) {
}
