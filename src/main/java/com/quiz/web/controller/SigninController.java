package com.quiz.web.controller;

import com.quiz.web.DefaultQuizController;
import com.quiz.web.dto.DefaultResponse;
import com.quiz.web.dto.SigninRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
public class SigninController implements DefaultQuizController {

    private final Logger log = LoggerFactory.getLogger(SigninController.class);

    @PostMapping("/signin")
    public DefaultResponse<List<String>> signin(@RequestBody @Valid SigninRequest request, BindingResult result) {

        log.info("[Enter] signin controller. param : {}", request);

        checkBindings(result);

        return DefaultResponse.success(Collections.EMPTY_LIST);

    }
}
