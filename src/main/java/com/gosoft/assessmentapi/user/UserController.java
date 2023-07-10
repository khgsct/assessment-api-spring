package com.gosoft.assessmentapi.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<UserLoginResponse> authenticate(@RequestBody UserLoginRequest loginRequest) {
        var token = this.userService.authenticate(loginRequest.email(), loginRequest.password());
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserLoginResponse(loginRequest.email(), token));
    }
}
