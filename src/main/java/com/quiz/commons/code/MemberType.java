package com.quiz.commons.code;

import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * - Admin : 최고 권한 관리자
 * - Staff : 관리자
 * - User : 사용자
 */
@Getter
public enum MemberType {

    ADMIN ("A", "관리자")
    ,
    STAFF ("S", "운영자")
    ,
    USER ("U", "사용자")
    ,
    ;

    private String code;

    private String value;

    MemberType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private static final Map<String, MemberType> map
            = Stream.of(MemberType.values()).collect(Collectors.toMap(MemberType::getCode, Function.identity()));

    public static MemberType from(String code) {
        return map.get(code);
    }
}
