package com.gosoft.assessmentapi.auth;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.security.auth.login.CredentialException;

@RestControllerAdvice
public class AuthControllerAdvice {

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage usernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
        return new ErrorMessage("user not found.");
    }

    @ExceptionHandler(CredentialException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage credentialException(CredentialException ex, WebRequest request) {
        return new ErrorMessage("invalid credential.");
    }
}
