package com.gosoft.assessmentapi.product;

import com.gosoft.assessmentapi.product.common.ProductNotFoundException;
import com.gosoft.assessmentapi.product.contract.ProductRepository;
import com.gosoft.assessmentapi.product.domain.Product;
import org.springframework.stereotype.Service;

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
