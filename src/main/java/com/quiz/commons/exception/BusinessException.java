package com.quiz.commons.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * HttpStatus : 200 으로 Return
 * Reason Code
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {

    public BusinessException() {
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
