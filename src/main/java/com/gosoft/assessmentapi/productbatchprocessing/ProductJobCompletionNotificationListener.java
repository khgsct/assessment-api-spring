package com.gosoft.assessmentapi.productbatchprocessing;

import com.gosoft.assessmentapi.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductJobCompletionNotificationListener implements JobExecutionListener {
    private static final Logger log = LoggerFactory.getLogger(ProductJobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    public ProductJobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        this.jdbcTemplate.query("SELECT name, price FROM products", (rs, row) -> {
            var product = new Product();
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            return product;
        })
        .forEach(product -> log.info("Job complete : Found <{{}}>", product));
    }
}
