package com.javastudio.tutorial.exception;

public class InvalidMessageTypeIndicatorException extends Exception {

    private static final long serialVersionUID = -8152675153345186337L;

    public InvalidMessageTypeIndicatorException() {
        super();
    }

    public InvalidMessageTypeIndicatorException(String message) {
        super(message);
    }

    public InvalidMessageTypeIndicatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMessageTypeIndicatorException(Throwable cause) {
        super(cause);
    }

    protected InvalidMessageTypeIndicatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
