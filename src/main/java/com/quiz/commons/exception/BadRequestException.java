package com.quiz.commons.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class BadRequestException extends RuntimeException {

    private List<FieldError> errors;
    private int code;
    private String message;

    public BadRequestException(String message, int code, BindingResult errors) {
        super(message);
        this.message = message;
        this.code = code;
        this.errors = errors.getFieldErrors();
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
