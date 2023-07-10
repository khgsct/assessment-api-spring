package com.gosoft.assessmentapi.cart;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void updateCart(UUID userId, UUID productId, int quantity) {

    }

    public List<Cart> getUserCart(UUID userId) {
        return null;
    }
}
