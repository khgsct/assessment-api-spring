package com.gosoft.assessmentapi.cart;

import java.util.UUID;

public record UpdateCartRequest (UUID productId, int quantity) { }
