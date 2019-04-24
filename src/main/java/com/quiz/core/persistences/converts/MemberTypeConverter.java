package com.quiz.core.persistences.converts;

import com.quiz.commons.code.MemberType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MemberTypeConverter implements AttributeConverter<MemberType, String> {

    @Override
    public String convertToDatabaseColumn(MemberType memberType) {
        return memberType.getCode();
    }

    @Override
    public MemberType convertToEntityAttribute(String code) {
        return MemberType.from(code);
    }
}
