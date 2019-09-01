package com.home.onlineshop.exceptions;

public class WareAlreadyExistException extends RuntimeException {
    public WareAlreadyExistException() {
    }

    public WareAlreadyExistException(String message) {
        super(message);
    }
}
