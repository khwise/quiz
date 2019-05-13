package com.quiz.core.services.member;

import com.quiz.commons.code.MemberStateCode;
import com.quiz.commons.code.MemberType;
import com.quiz.core.entity.Member;
import com.quiz.core.persistences.repository.MemberRepository;
import com.quiz.web.dto.DefaultResponse;
import com.quiz.web.dto.JoinRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MemberServiceImpl implements MemberService {

    private final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(@Qualifier("memberRepository") MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public DefaultResponse<Member> join(JoinRequest request) {
        Member newMember = memberRepository.save(
                Member.builder()
                        .id(request.getId())
                        .password(request.getPassword())
                        .memberState(MemberStateCode.ACTIVATION)
                        .memberType(MemberType.USER)
                        .lastPasswordChangedDate(LocalDate.now())
                .build()
        );

        log.debug("New Member : {}", newMember);

        // JPA 연결 작업 진행
        return DefaultResponse.success(newMember);
    }
}
