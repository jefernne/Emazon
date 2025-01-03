package com.app.emazon.domain.brand.error;

public class MessageErrorBrand {
    private String field;
    private String Message;

    public MessageErrorBrand(String field, String Message) {
        this.field = field;
        this.Message = Message;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getMessage() {
        return Message;
    }
    public void setMessage(String message) {
        Message = message;
    }

}
