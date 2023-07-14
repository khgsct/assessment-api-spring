package com.gosoft.assessmentapi.cart;

import com.gosoft.assessmentapi.cart.contract.CartRepository;
import com.gosoft.assessmentapi.cart.domain.Cart;
import com.gosoft.assessmentapi.cart.domain.CartSummary;
import com.gosoft.assessmentapi.product.common.ProductNotFoundException;
import com.gosoft.assessmentapi.product.contract.ProductRepository;
import com.gosoft.assessmentapi.user.domain.User;
import com.gosoft.assessmentapi.user.contract.UserRepository;
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

    public void updateCart(User customer, UUID productId, int quantity) {
        var cartFromDb = this.cartRepository
                .findOptionalByProductIdAndUserId(productId, customer.getId());

        var cartInstance = cartFromDb.isPresent() ? cartFromDb.get() : new Cart();
        cartInstance.setQuantity(quantity);
        cartInstance.setUpdatedAt(LocalDateTime.now());

        if (!cartFromDb.isPresent()) {
            var product = this.productRepository.findById(productId)
                    .orElseThrow(ProductNotFoundException::new);
            cartInstance.setUser(customer);
            cartInstance.setProduct(product);
            cartInstance.setCreatedAt(LocalDateTime.now());
        }

        this.cartRepository.save(cartInstance);
    }

    public CartSummary getCartSummary(UUID userId) {
        var cartDetails = this.cartRepository.findAllByUserId(userId);
        var cartSummary = CartSummary
                .builder()
                .cartDetails(cartDetails)
                .build();
        return cartSummary;
    }

    public void deleteCart(UUID id) {
        this.cartRepository.deleteById(id);
    }
}
