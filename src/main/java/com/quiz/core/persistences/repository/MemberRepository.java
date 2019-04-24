package com.quiz.core.persistences.repository;

import com.quiz.core.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
