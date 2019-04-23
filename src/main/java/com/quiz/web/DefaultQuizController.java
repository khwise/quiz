package com.quiz.web;

import com.quiz.commons.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public interface DefaultQuizController {
    default void checkBindings(BindingResult result) {
        if (result.hasErrors()) {
            // todo : message 처리
            throw new BadRequestException("Invalid parameter.", HttpStatus.BAD_REQUEST.value(), result);
        }
    }
}

