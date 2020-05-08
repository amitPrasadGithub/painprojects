package com.perficient.Spring_POC.exception;

public class UnmodifiableEntityException extends RuntimeException {
    public UnmodifiableEntityException(String msg) {
        super(msg);
    }
}
