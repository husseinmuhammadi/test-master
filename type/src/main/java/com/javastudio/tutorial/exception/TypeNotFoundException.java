package com.javastudio.tutorial.exception;

public class TypeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 3832062633069159111L;

    public TypeNotFoundException() {
        super();
    }

    public TypeNotFoundException(String message) {
        super(message);
    }

    public TypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeNotFoundException(Throwable cause) {
        super(cause);
    }

    protected TypeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
