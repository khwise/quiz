package com.quiz.core.entity;

import com.quiz.commons.code.MemberStateCode;
import com.quiz.commons.code.MemberType;
import com.quiz.commons.domain.Auditable;
import com.quiz.core.persistences.converts.MemberStateCodeConverter;
import com.quiz.core.persistences.converts.MemberTypeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
@Table(name = "tb_member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends Auditable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(name = "id")
    @NotBlank
    private String id;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "member_type")
    @Convert(converter = MemberTypeConverter.class)
    private MemberType memberType;

    @Column(name = "state_cd")
    @Convert(converter = MemberStateCodeConverter.class)
    private MemberStateCode memberState;

    @Column(name = "last_password_changed_date")
    private LocalDate lastPasswordChangedDate;
}
