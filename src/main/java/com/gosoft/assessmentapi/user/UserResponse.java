package com.gosoft.assessmentapi.user;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(UUID id, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
