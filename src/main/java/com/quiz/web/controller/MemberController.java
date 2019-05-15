package com.quiz.web.controller;

import com.quiz.core.entity.Member;
import com.quiz.core.services.member.MemberService;
import com.quiz.web.DefaultQuizController;
import com.quiz.web.dto.DefaultResponse;
import com.quiz.web.dto.JoinRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
public class MemberController implements DefaultQuizController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    private MemberService memberService;

    @Autowired
    public MemberController(
            @Qualifier("memberServiceImpl") MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public DefaultResponse<Member> join(@RequestBody @Valid JoinRequest request, BindingResult result) {
        checkBindings(result);
        return memberService.join(request);
    }
}
