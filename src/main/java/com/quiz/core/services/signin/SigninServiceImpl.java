package com.quiz.core.services.signin;

import com.quiz.commons.utils.JwtCreator;
import com.quiz.core.entity.Member;
import com.quiz.core.persistences.MemberRepositoryService;
import com.quiz.web.dto.SigninRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SigninServiceImpl implements SigninService {

    private static final Logger log = LoggerFactory.getLogger(SigninServiceImpl.class);

    private MemberRepositoryService memberRepositoryService;

    private JwtCreator jwtCreator;

    @Autowired
    public SigninServiceImpl(
            @Qualifier("memberRepositoryServiceImpl") MemberRepositoryService memberRepositoryService,
            @Qualifier("jwtCreator") JwtCreator jwtCreator
            ) {
        this.memberRepositoryService = memberRepositoryService;
        this.jwtCreator = jwtCreator;
    }

    @Override
    public void signin(SigninRequest request) {

        // member 조회
        Member member = memberRepositoryService.selectByUserId(request.getUserId());

        // password 검증
        String dbPassword = member.getPassword();
        if (StringUtils.isEmpty(dbPassword)) {

        }

        if (!dbPassword.equals(request.getPassword())) {
            // todo : Business Exception 발생.
        }

    }

}

