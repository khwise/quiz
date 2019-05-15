package com.quiz.web.controller;

import com.quiz.core.entity.CommonCodeGroup;
import com.quiz.core.entity.CommonCodeItem;
import com.quiz.core.services.admin.CommonCodeService;
import com.quiz.web.DefaultQuizController;
import com.quiz.web.dto.CommonCodeRequest;
import com.quiz.web.dto.DefaultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/commons/codes")
public class CommonCodeController implements DefaultQuizController {

    private final Logger log = LoggerFactory.getLogger(CommonCodeController.class);

    private CommonCodeService commonCodeService;

    @Autowired
    public CommonCodeController(
            @Qualifier("commonCodeServiceImpl") CommonCodeService commonCodeService
    ) {
        this.commonCodeService = commonCodeService;
    }

    @PostMapping(value = "/group")
    public DefaultResponse<CommonCodeGroup> createGroup(@RequestBody @Valid CommonCodeRequest request, BindingResult result) {
        checkBindings(result);
        return DefaultResponse.success(commonCodeService.createGroup(request));
    }

    @PostMapping(value = "/{id}/item")
    public DefaultResponse<CommonCodeItem> createItem(@PathVariable String id, @RequestBody @Valid CommonCodeRequest request, BindingResult result) {
        checkBindings(result);
        return DefaultResponse.success(commonCodeService.createItem(id, request));
    }
}
