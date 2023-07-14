package com.gosoft.assessmentapi.cart.domain;

import com.gosoft.assessmentapi.product.domain.Product;
import com.gosoft.assessmentapi.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {
    @Id
    @UuidGenerator
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    private double totalPrice;
    public double getTotalPrice() {
        return this.quantity * this.getProduct().getPrice();
    }
}
