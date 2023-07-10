package com.gosoft.assessmentapi.cart;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/carts")
public class CartController {

    @GetMapping(path = "/")
    public ResponseEntity<List<CartResponse>> getUserCart() {
        Cart cart = null;
        if (cart != null)
            return ResponseEntity.status(HttpStatus.OK).body(null);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping(path = "/")
    public ResponseEntity<?> updateCart(@RequestBody UpdateCartRequest updateCartRequest) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
