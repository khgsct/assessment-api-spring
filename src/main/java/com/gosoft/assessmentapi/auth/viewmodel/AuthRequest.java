package com.gosoft.assessmentapi.auth.viewmodel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AuthRequest(@Email String email, @NotNull String password) {
}
