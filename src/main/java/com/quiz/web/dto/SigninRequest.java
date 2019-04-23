package com.quiz.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SigninRequest {

    @JsonProperty("user_id")
    @NotBlank
    private String userId;

    @JsonProperty("password")
    @NotBlank
    private String password;
}
