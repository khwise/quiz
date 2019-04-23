package com.quiz.core.entity;

import com.quiz.commons.code.MemberStateCode;
import com.quiz.commons.code.MemberType;
import com.quiz.commons.domain.BaseDomain;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Member
 * |_ 사용자 ID
 * |_ 패스워드
 * |_ 프로필
 *    |_ 이름, email, 전화번호
 * |_ 권한
 *   |_ 어드민/스텝/사용자
 * |_ 등급
 *   |_ 어드민/스텝/사용자
 */

@Entity
@Table(name = "TB_MEMBER")
@Data
public class Member extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "member_type")
    private MemberType memberType;

    @Column(name = "member_state")
    private MemberStateCode memberState;

    @Column(name = "last_password_changed_date")
    private LocalDate lastPasswordChangedDate;
}
