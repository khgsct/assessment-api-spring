package com.gosoft.assessmentapi.cart;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartSummary {
    private Iterable<Cart> cartDetails;
    private double totalPrice;

    public double getTotalPrice() {
        double totalPrice = 0d;
        var iterator = cartDetails.iterator();
        while (iterator.hasNext()) {
            var currentCart = iterator.next();
            totalPrice += currentCart.getTotalPrice();
        }
        return totalPrice;
    }
}

