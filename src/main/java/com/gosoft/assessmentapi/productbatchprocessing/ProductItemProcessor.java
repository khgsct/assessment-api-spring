package com.gosoft.assessmentapi.productbatchprocessing;

import com.gosoft.assessmentapi.product.Product;
import com.gosoft.assessmentapi.product.ProductBatchItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductItemProcessor implements ItemProcessor<ProductBatchItem, Product> {

    private static final Logger log = LoggerFactory.getLogger(ProductItemProcessor.class);

    @Override
    public Product process(ProductBatchItem item) throws Exception {
        var product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(item.getName());
        product.setPrice(item.getPrice());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        log.info("Converting : " + item.getName());

        return product;
    }
}
