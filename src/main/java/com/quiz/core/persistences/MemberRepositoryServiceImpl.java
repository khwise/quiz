package com.quiz.core.persistences;

import com.quiz.core.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberRepositoryServiceImpl implements MemberRepositoryService {

    @Override
    public Member selectByUserId(String userId) {
        // todo : DB 연결 구현 (테이블 설계 후 필드 추가 JPA 로 연결)
        Member m = new Member();
        m.setId("test");
        m.setPassword("test");

        return m;
    }
}
