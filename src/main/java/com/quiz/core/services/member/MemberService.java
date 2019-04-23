package com.quiz.core.services.member;

import com.quiz.core.entity.Member;
import com.quiz.web.dto.DefaultResponse;
import com.quiz.web.dto.JoinRequest;

public interface MemberService {

    DefaultResponse<Member> join(JoinRequest request);
}
