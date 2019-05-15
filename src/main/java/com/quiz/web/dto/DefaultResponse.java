package com.quiz.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DefaultResponse<T> {

    private static final String DEFAULT_RETURN_MESSAGE = "success";
    private static final int DEFAULT_RETURN_CODE = 0;

    private String message;
    private int code;
    private T result;

    private DefaultResponse(String message, int code, T result) {
        this.message = message;
        this.code = code;
        this.result = result;
    }

    public static <T> DefaultResponse<T> success(T result) {
        return new DefaultResponse<>(DEFAULT_RETURN_MESSAGE, DEFAULT_RETURN_CODE, result);
    }

    public static <T> DefaultResponse<T> error(String message, int code, T errors) {
        return new DefaultResponse<T>(message, code, errors);
    }
}
