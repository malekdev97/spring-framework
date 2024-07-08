package com.backend.backend.exception;

public class ReviewNotFoundException extends RuntimeException {
    
    private static final long serivalVersionUID = 1L;

    public ReviewNotFoundException(String msg) {
        super(msg);
    }
}
