package com.gosoft.assessmentapi.product.contract;

import com.gosoft.assessmentapi.product.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> { }
