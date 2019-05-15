package com.quiz.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CommonCodeRequest {

    @JsonProperty("code")
    @Size(max = 4, min = 4)
    private String code;

    @JsonProperty("code_name")
    @NotBlank
    private String codeName;

    @JsonProperty("code_value")
    private String codeValue;

    @JsonProperty("code_desc")
    private String codeDesc;

    @JsonProperty("used")
    private Boolean used;

    @JsonProperty("cache")
    private Boolean cache;
}
