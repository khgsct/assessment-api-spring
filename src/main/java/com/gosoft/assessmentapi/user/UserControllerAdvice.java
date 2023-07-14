package com.gosoft.assessmentapi.user;

import com.gosoft.assessmentapi.user.common.UserNotFoundException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage userNotFoundException(UserNotFoundException ex, WebRequest request) {
        return new ErrorMessage("user not found.");
    }

}
