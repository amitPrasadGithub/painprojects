package com.perficient.Spring_POC.exception;

public class CustomEntityNotFoundException extends RuntimeException {
    public CustomEntityNotFoundException(String msg) {
        super(msg);
    }
}
