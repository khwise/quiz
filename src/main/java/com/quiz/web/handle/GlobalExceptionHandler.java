package com.quiz.web.handle;

import com.quiz.commons.exception.BadRequestException;
import com.quiz.commons.exception.BusinessException;
import com.quiz.web.dto.DefaultResponse;
import com.quiz.web.dto.ErrorResponse;
import com.quiz.web.dto.Reason;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<DefaultResponse> handleBadRequestException(BadRequestException e, HttpServletRequest request) {
        log.info("[request] : {}",request.toString());
        log.error("[error] {}", e.toString());

        ErrorResponse error = new ErrorResponse();
        error.setOccurredTime(LocalDateTime.now());
        error.setPath(request.getRequestURI());
        error.setException(e.getClass().toString());
        error.setErrors(e.getErrors().stream().map(err -> Reason.of(err)).collect(Collectors.toList()));

        return new ResponseEntity<>(DefaultResponse.error(e.getMessage(), e.getCode(), error), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<DefaultResponse> handleBusinessException(BusinessException e) {
        // todo : 정의하기
        return new ResponseEntity<>(DefaultResponse.error("", 0, null), HttpStatus.OK);
    }

//    @ExceptionHandler(Exception.class)
//    protected ResponseEntity<DefaultResponse> handleException(Exception e, HttpServletRequest request) {
//        log.info("[request] : {}",request);
//        log.error("[error] {}", e);
//        return new ResponseEntity<>(DefaultResponse.error("", null), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
