package com.backend.backend.exception;

import java.util.Date;
import lombok.Data;

@Data
public class ErrorMessage {
    private Integer statusCode;
    private String message;
    private Date timestamp;
}
