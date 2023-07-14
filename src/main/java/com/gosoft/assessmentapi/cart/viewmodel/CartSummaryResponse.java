package com.gosoft.assessmentapi.cart.viewmodel;

import java.util.List;

public record CartSummaryResponse(List<CartResponse> cartDetails, double totalPrice) {
}
