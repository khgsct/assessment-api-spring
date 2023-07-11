package com.gosoft.assessmentapi.auth;

import com.gosoft.assessmentapi.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.CredentialException;

@RestController
@RequestMapping(path = "api/v1/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "")
    public ResponseEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest authRequest) throws CredentialException {
        var token = this.userService.authenticate(authRequest.email(), authRequest.password());
        return ResponseEntity.status(HttpStatus.CREATED).body(AuthResponse
                .builder()
                .email(authRequest.email())
                .token(token)
                .build());
    }

}
