package com.gosoft.assessmentapi.cart;

import com.gosoft.assessmentapi.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<CartResponse>> getUserCart() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var currentUser = (User)auth.getPrincipal();
        var userCart = this.cartService.getUserCart(currentUser.getId());
        var response = CartMapper.MAPPER.toResponse(userCart);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(path = "")
    public ResponseEntity<?> updateCart(@RequestBody UpdateCartRequest updateCartRequest) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var currentUser = (User)auth.getPrincipal();
        this.cartService.updateCart(currentUser.getId(), updateCartRequest.productId(), updateCartRequest.quantity());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
