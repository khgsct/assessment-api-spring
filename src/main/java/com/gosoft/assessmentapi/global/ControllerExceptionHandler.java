package com.gosoft.assessmentapi.global;

import com.gosoft.assessmentapi.product.ProductNotFoundException;
import com.gosoft.assessmentapi.user.UserNotFoundException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.security.auth.login.CredentialException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage usernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
        return new ErrorMessage("user not found.");
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage userNotFoundException(UserNotFoundException ex, WebRequest request) {
        return new ErrorMessage("user not found.");
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage productNotFoundException(ProductNotFoundException ex, WebRequest request) {
        return new ErrorMessage("product not found.");
    }

    @ExceptionHandler(CredentialException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage credentialException(CredentialException ex, WebRequest request) {
        return new ErrorMessage("invalid credential.");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        return new ErrorMessage("route not found.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
