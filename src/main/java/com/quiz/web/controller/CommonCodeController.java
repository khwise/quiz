package com.quiz.web.controller;

import com.quiz.web.DefaultQuizController;
import com.quiz.web.dto.CommonCodeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController(value = "/commons/codes")
public class CommonCodeController implements DefaultQuizController {

    private final Logger log = LoggerFactory.getLogger(CommonCodeController.class);

    @PostMapping
    public void createCommonCodes(@RequestBody @Valid CommonCodeRequest request, BindingResult result) {
        checkBindings(result);

    }

    @PutMapping
    public void updateCode() {

    }

    @DeleteMapping
    public void deleteCode() {

    }


}
