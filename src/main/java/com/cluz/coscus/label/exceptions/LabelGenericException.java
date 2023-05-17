package com.cluz.coscus.label.exceptions;

public class LabelGenericException extends RuntimeException {
    public LabelGenericException() {
        super("Generic error.");
    }

    public LabelGenericException(String message) {
        super(message);
    }
}
