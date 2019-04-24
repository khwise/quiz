package com.quiz.commons.code;

import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum MemberStateCode {

    ACTIVATION(1, "활동")
    ,
    INACTIVE(2, "활동")
    ,
    BLOCK(3, "차단")
    ;

    private Integer code;

    private String value;

    MemberStateCode(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    private static final Map<Integer, MemberStateCode> map
            = Stream.of(MemberStateCode.values()).collect(Collectors.toMap(MemberStateCode::getCode, Function.identity()));

    public static MemberStateCode from(Integer code) {
        return map.get(code);
    }
}
