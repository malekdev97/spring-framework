package com.backend.backend.exception;

public class DepartmentNotFoundException extends RuntimeException {
    
    private static final long serivalVersionUID = 1L;

    public DepartmentNotFoundException(String msg) {
        super(msg);
    
    }
}
