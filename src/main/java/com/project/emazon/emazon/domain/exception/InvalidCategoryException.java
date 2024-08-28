package com.project.emazon.emazon.domain.exception;


import java.util.List;

public class InvalidCategoryException extends RuntimeException {

  private List<ValidationError> errors;



    public InvalidCategoryException(String message, List<ValidationError> errors) {
        super(message);
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
