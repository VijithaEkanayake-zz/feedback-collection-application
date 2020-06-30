package com.vijitha.feedback.collector.service.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Required input parameters not found")
public class DataValidationException extends RuntimeException {

    public DataValidationException() {
        super();
    }

    public DataValidationException(String message) {
        super(message);
    }

}
