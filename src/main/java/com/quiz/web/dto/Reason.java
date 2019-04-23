package com.quiz.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.FieldError;

@Data
public class Reason {
    private String field;
    private String code;

    @JsonProperty("message")
    private String defaultMessage;

    private Reason(String field, String code, String defaultMessage) {
        this.field = field;
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public static Reason of(FieldError error) {
        return new Reason(error.getField(), error.getCode(), error.getDefaultMessage());
    }
}
