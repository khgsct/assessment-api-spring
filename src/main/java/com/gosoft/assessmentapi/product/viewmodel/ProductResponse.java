package com.gosoft.assessmentapi.product.viewmodel;

import java.util.UUID;

public record ProductResponse (UUID id, String name, double price) { }
