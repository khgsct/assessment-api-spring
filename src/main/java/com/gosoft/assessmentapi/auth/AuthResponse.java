package com.gosoft.assessmentapi.auth;

import lombok.Builder;

@Builder
public record AuthResponse(String email, String token) {
}
