package com.backend.backend.exception;

public class ProductNotFoundException extends RuntimeException {

    private static final long serivalVersionUID = 1L;

    public ProductNotFoundException(String msg) {
        super(msg);
    }
    
}
