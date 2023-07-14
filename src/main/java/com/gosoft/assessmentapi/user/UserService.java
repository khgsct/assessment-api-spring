package com.gosoft.assessmentapi.user;

import com.gosoft.assessmentapi.auth.JwtService;
import com.gosoft.assessmentapi.user.contract.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;

@Service
public class UserService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final UserPasswordService userPasswordService;

    public UserService(AuthenticationManager authenticationManager, JwtService jwtService, UserRepository userRepository, UserPasswordService userPasswordService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.userPasswordService = userPasswordService;
    }

    public String authenticate(String username, String password) throws CredentialException {
        var user = userRepository.findOptionalByEmail(username)
                .orElseThrow(CredentialException::new);
        if (!this.userPasswordService.matches(password, user.getPassword())) {
            throw new CredentialException();
        }
        var token = this.jwtService.generateToken(user.getUsername());
        return token;
    }
}
