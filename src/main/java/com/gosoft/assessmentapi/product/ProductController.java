package com.gosoft.assessmentapi.product;

import com.gosoft.assessmentapi.global.SecurityController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController  extends SecurityController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<ProductResponse>> getProducts() {
        var products = this.productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(ProductMapper.MAPPER.toResponse(products));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable UUID id) {
        var product = this.productService.getProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(ProductMapper.MAPPER.toResponse(product));
    }
}
