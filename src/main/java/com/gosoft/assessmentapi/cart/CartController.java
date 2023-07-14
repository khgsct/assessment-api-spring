package com.gosoft.assessmentapi.cart;

import com.gosoft.assessmentapi.BaseController;
import com.gosoft.assessmentapi.cart.contract.CartMapper;
import com.gosoft.assessmentapi.cart.viewmodel.CartCreationRequest;
import com.gosoft.assessmentapi.cart.viewmodel.CartSummaryResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/carts")
public class CartController extends BaseController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "")
    public ResponseEntity<CartSummaryResponse> getUserCart() {
        var cartSummary = this.cartService.getCartSummary(Me().getId());
        return ResponseEntity.status(HttpStatus.OK)
                .body(CartMapper.MAPPER.toResponse(cartSummary));
    }

    @PutMapping(path = "")
    public ResponseEntity updateCart(@Valid @RequestBody CartCreationRequest cartCreationRequest) {
        this.cartService.updateCart(Me(), cartCreationRequest.productId(), cartCreationRequest.quantity());
        return ResponseEntity.noContent().build();
    }

}
