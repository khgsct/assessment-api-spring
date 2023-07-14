package com.gosoft.assessmentapi.product;

import com.gosoft.assessmentapi.product.common.ProductNotFoundException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage productNotFoundException(ProductNotFoundException ex, WebRequest request) {
        return new ErrorMessage("product not found.");
    }
}
