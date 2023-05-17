package com.cluz.coscus.label.exceptions;

public class LabelResourceException extends LabelGenericException {
    public LabelResourceException() {
        super("Resource already exists.");
    }

    public LabelResourceException(String code) {
        super(String.format("Resource already exists with code: %s.", code));
    }

    public LabelResourceException(String resource, String code) {
        super(String.format("%s already exists with code: %s.", resource, code));
    }
}
