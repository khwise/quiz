package com.quiz.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ErrorResponse {

    @JsonProperty("path")
    private String path;

    @JsonProperty("occurred-date-time")
    private LocalDateTime occurredTime;

    @JsonProperty("exception")
    private String exception;

    @JsonProperty("errors")
    private List<Reason> errors;
}
