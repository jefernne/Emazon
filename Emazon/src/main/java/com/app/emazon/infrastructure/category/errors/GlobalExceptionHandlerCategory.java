package com.app.emazon.infrastructure.category.errors;

import com.app.emazon.domain.category.error.InvalidCategoryExection;
import com.app.emazon.domain.category.error.MessageErrorCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandlerCategory {

    @ExceptionHandler(InvalidCategoryExection.class)
    public ResponseEntity<List<MessageErrorCategory>> handleInvalidCategoryException(InvalidCategoryExection ex) {
        List<MessageErrorCategory> errors = ex.getErrors().stream().collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_GATEWAY);
    }
}
