package com.gosoft.assessmentapi.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getProducts() {
        var products = this.productRepository.findAll();
        return products;
    }

    public Product getProduct(UUID id) {
        var product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        return product;
    }
}
