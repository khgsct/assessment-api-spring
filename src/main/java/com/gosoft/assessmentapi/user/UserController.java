package com.gosoft.assessmentapi.user;

import com.gosoft.assessmentapi.BaseController;
import com.gosoft.assessmentapi.user.contract.UserLoginMapper;
import com.gosoft.assessmentapi.user.viewmodel.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/me")
    public ResponseEntity<UserResponse> me() {
        return ResponseEntity.status(HttpStatus.OK).body(
                UserLoginMapper.MAPPER.toResponse(Me()));
    }
}
