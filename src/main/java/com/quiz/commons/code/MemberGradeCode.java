package com.quiz.commons.code;

import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum MemberGradeCode {

    NON_MEMBER(0, "비회원")
    ,
    SEMI_MEMBER(1, "비회원")
    ,
    REGULAR_MEMBER(2, "정회원")
    ;

    private Integer code;

    private String value;

    MemberGradeCode(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    private static final Map<Integer, MemberGradeCode> map
            = Stream.of(MemberGradeCode.values()).collect(Collectors.toMap(MemberGradeCode::getCode, Function.identity()));

    private static MemberGradeCode from(Integer code) {
        return map.get(code);
    }
}
