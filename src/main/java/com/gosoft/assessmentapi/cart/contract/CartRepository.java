package com.gosoft.assessmentapi.cart.contract;

import com.gosoft.assessmentapi.cart.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends CrudRepository<Cart, UUID> {
    Iterable<Cart> findAllByUserId(UUID userId);

    Optional<Cart> findOptionalByProductIdAndUserId(UUID productId, UUID userId);
}
