package com.app.emazon.domain.category.error;

import java.util.List;

public class InvalidCategoryExection extends RuntimeException{
    private List<MessageError> errors;

    public InvalidCategoryExection(String message,List<MessageError> errors) {
        super(message);
        this.errors = errors;
    }

    public List<MessageError> getErrors() {
        return errors;
    }
}

