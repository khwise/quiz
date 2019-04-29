package com.quiz.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CommonCodeRequest {

    @JsonProperty("code")
    @Max(4)
    @Min(4)
    private String code;

    @JsonProperty("code_name")
    @NotBlank
    private String codeName;

    @JsonProperty("code_value")
    private String codeValue;

    @JsonProperty("code_desc")
    private String codeDesc;

    @JsonProperty("used")
    @NotNull
    private Boolean used;

    @JsonProperty("cache")
    @NotNull
    private Boolean cache;
}
