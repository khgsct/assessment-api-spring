package com.gosoft.assessmentapi.user;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticate(UserLoginRequest loginRequest) {
        return null;
    }
}
