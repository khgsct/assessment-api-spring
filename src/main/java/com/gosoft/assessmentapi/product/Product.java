package com.gosoft.assessmentapi.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false)
    private String updatedBy;
}
