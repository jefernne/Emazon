package com.app.emazon.domain.brand.error;

import org.springframework.context.support.MessageSourceAccessor;

import java.util.List;

public class InvalidBrandeExection  extends RuntimeException{
    private List<MessageErrorBrand> errors;

    public InvalidBrandeExection(String message,List<MessageErrorBrand> errors) {
        super(message);
        this.errors = errors;
    }
    public List<MessageErrorBrand> getErrors() {
        return errors;
    }
}
