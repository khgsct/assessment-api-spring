package com.gosoft.assessmentapi.global;

import com.gosoft.assessmentapi.user.User;
import jakarta.annotation.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class SecurityController {

    @Nullable
    public User Me() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var currentUser = auth != null && auth.isAuthenticated() ? (User)auth.getPrincipal() : null;
        return currentUser;
    }

}
