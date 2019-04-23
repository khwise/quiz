package com.quiz.core.persistences;


import com.quiz.core.entity.Member;

public interface MemberRepositoryService {

    Member selectByUserId(String userId);
}
