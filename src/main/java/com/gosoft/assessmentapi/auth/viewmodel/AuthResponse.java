package com.gosoft.assessmentapi.auth.viewmodel;

import lombok.Builder;

@Builder
public record AuthResponse(String email, String token) {
}
