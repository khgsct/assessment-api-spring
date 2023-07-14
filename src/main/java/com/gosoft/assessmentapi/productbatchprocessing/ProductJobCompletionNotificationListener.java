package com.gosoft.assessmentapi.productbatchprocessing;

import com.gosoft.assessmentapi.product.contract.ProductRepository;
import com.gosoft.assessmentapi.productpicture.ProductPictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProductJobCompletionNotificationListener implements JobExecutionListener {
    private static final Logger log = LoggerFactory.getLogger(ProductJobCompletionNotificationListener.class);
    private final ProductRepository productRepository;
    private final ProductPictureService productPictureService;

    public ProductJobCompletionNotificationListener(ProductRepository productRepository, ProductPictureService productPictureService) {
        this.productRepository = productRepository;
        this.productPictureService = productPictureService;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        productRepository.findAll()
                .forEach(p -> {
                    try {
                        var productPicture = new ClassPathResource("product-image.webp");
                        var output = productPictureService.AddProductPicture(p, new MockMultipartFile(productPicture.getFilename(), productPicture.getContentAsByteArray()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
