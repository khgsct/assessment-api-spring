package com.gosoft.assessmentapi.productbatchprocessing;

import com.gosoft.assessmentapi.product.Product;
import com.gosoft.assessmentapi.product.ProductBatchItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ProductBatchConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ProductBatchConfiguration.class);

    private final JdbcTemplate jdbcTemplate;

    public ProductBatchConfiguration(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public FlatFileItemReader<ProductBatchItem> reader() {
        clearProducts();

        return new FlatFileItemReaderBuilder<ProductBatchItem>()
                .name("productItemReader")
                .resource(new ClassPathResource("product-data.csv"))
                .delimited()
                .names(new String[]{"name", "price"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<ProductBatchItem>() {{
                    setTargetType(ProductBatchItem.class);
                }})
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Product> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Product>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO products (id, name, price, created_at, updated_at) VALUES (:id, :name, :price, :createdAt, :updatedAt)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importProductJob(JobRepository jobRepository,
                                ProductJobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importProductJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step processProductStep(JobRepository jobRepository,
                                   PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Product> writer) {
        return new StepBuilder("processProductStep", jobRepository)
                .<ProductBatchItem, Product> chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

    @Bean
    public ProductItemProcessor processor() {
        return new ProductItemProcessor();
    }

    private void clearProducts() {
        this.jdbcTemplate
                .update("DELETE FROM products where name in ('product-1','product-2','product-3')");
        log.info("Clean up products complete");
    }

}
