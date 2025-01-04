package com.app.emazon.domain.category.error;

import java.util.List;

public class InvalidCategoryExection extends RuntimeException{
    private List<MessageErrorCategory> errors;

    public InvalidCategoryExection(String message,List<MessageErrorCategory> errors) {
        super(message);
        this.errors = errors;
    }

    public List<MessageErrorCategory> getErrors() {
        return errors;
    }
}

