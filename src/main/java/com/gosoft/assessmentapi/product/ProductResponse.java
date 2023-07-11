package com.gosoft.assessmentapi.product;

import java.util.UUID;

public record ProductResponse (UUID id, String name, double price) { }
