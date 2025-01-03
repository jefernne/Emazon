package com.app.emazon.infrastructure.brand.errors;

import com.app.emazon.domain.brand.error.InvalidBrandeExection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExeptionHandlerBrand {
    @ExceptionHandler(InvalidBrandeExection.class)
    public ResponseEntity<List<FieldErrorBrand>>handleInvalidBrandException(InvalidBrandeExection ex) {
        List<FieldErrorBrand>fieldErrorsBrand =ex.getErrors().stream().map(error -> new FieldErrorBrand(error.getField(),error.getMessage())).collect(Collectors.toList());
        return  new ResponseEntity<>(fieldErrorsBrand,  HttpStatus.BAD_GATEWAY);
    }
}
