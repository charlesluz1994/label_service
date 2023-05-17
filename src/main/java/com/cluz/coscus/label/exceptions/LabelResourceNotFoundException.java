package com.cluz.coscus.label.exceptions;

import java.util.UUID;

public class LabelResourceNotFoundException extends LabelGenericException {
    public LabelResourceNotFoundException() {
        super("Resource not found.");
    }

    public LabelResourceNotFoundException(UUID id) {
        super(String.format("Resource not found with id: %s.", id));
    }

    public LabelResourceNotFoundException(String resource) {
        super(String.format("%s not found.", resource));
    }

    public LabelResourceNotFoundException(String resource, UUID id) {
        super(String.format("%s not found with id: %s.", resource, id));
    }
}
