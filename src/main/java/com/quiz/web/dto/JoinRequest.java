package com.quiz.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * String 의 경우 NotBlank, Integer(Long) 의 경우 NotEmpty
 */

@Data
public class JoinRequest {

    @JsonProperty("login_id")
    @NotBlank
    private String id;

    @JsonProperty("password")
    @NotBlank
    private String password;

}
