package com.quiz.core.persistences.converts;

import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean b) {
        return b ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String b) {
        if (StringUtils.isEmpty(b)) {
            return false;
        }

        return b.equals("Y") ? true : false;
    }
}
