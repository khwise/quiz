package com.quiz.core.services.member;

import com.quiz.core.entity.Member;
import com.quiz.web.dto.DefaultResponse;
import com.quiz.web.dto.JoinRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Override
    public DefaultResponse<Member> join(JoinRequest request) {
        // JPA 연결 작업 진행
        return DefaultResponse.success(new Member());
    }
}
