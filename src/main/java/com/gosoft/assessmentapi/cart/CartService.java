package com.gosoft.assessmentapi.cart;

import com.gosoft.assessmentapi.product.ProductNotFoundException;
import com.gosoft.assessmentapi.product.ProductRepository;
import com.gosoft.assessmentapi.user.UserNotFoundException;
import com.gosoft.assessmentapi.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public void updateCart(UUID userId, UUID productId, int quantity) {
        var user = this.userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        var product = this.productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);

        var cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(quantity);
        cart.setCreatedAt(LocalDateTime.now());
        cart.setUpdatedAt(LocalDateTime.now());
    }

    public Iterable<Cart> getUserCart(UUID userId) {
        var cart = this.cartRepository.findAllByUserId(userId);
        return cart;
    }
}
