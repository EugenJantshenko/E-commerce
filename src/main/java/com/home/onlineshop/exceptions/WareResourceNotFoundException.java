package com.home.onlineshop.exceptions;

public class WareResourceNotFoundException extends RuntimeException {

    public WareResourceNotFoundException() {
    }

    public WareResourceNotFoundException(String message) {
        super(message);
    }

    public WareResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WareResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
