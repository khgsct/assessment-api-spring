package com.gosoft.assessmentapi.productbatchprocessing;

import com.gosoft.assessmentapi.product.contract.ProductRepository;
import com.gosoft.assessmentapi.productpicture.ProductPictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
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
        var productPicture = new ClassPathResource("product-image.jpg");
        productRepository.findAll()
                .forEach(product -> {
                    try {
                        var file = new MockMultipartFile(
                                productPicture.getFilename(),
                                productPicture.getFilename(),
                                MediaType.IMAGE_JPEG_VALUE,
                                productPicture.getInputStream());
                        productPictureService.AddProductPicture(product, file);
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                        throw new RuntimeException(e);
                    }
                });
    }
}
