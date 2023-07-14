package com.gosoft.assessmentapi;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BaseControllerAdvice {

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
