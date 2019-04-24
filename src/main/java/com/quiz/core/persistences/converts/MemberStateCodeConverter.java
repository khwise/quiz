package com.quiz.core.persistences.converts;

import com.quiz.commons.code.MemberStateCode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MemberStateCodeConverter implements AttributeConverter<MemberStateCode, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MemberStateCode memberStateCode) {
        return memberStateCode.getCode();
    }

    @Override
    public MemberStateCode convertToEntityAttribute(Integer code) {
        return MemberStateCode.from(code);
    }
}
