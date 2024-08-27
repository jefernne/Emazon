package com.project.emazon.emazon.infrastructure.errors;

import com.project.emazon.emazon.domain.exception.InvalidCategoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCategoryException.class)
    public ResponseEntity<List<FieldError>>handleInvalidCategoryException(InvalidCategoryException ex){
        List<FieldError> fieldErrors = ex.getErrors().stream()
                .map(error -> new FieldError(error.getField(),error.getMessage())).collect(Collectors.toList());
        return new ResponseEntity<>(fieldErrors, HttpStatus.BAD_REQUEST);
    }
}
