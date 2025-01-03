package com.app.emazon.infrastructure.brand.errors;

public class FieldErrorBrand {
    private String field;
    private String message;


    public FieldErrorBrand(String field, String message) {
    this.field = field;
    this.message = message;
    }


    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
