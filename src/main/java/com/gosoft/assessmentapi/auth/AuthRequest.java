package com.gosoft.assessmentapi.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AuthRequest(@Email String email, @NotNull String password) {
}
