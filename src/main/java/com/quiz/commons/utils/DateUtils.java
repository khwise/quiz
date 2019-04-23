package com.quiz.commons.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 날짜, 시간에 관련 된 기능을 정의한다.
 * 기본적으로 자바 8부터 지원하는 LocalDateTime 을 사용한다.
 */
public class DateUtils {

    public static LocalDate from(String strDate, String pattern) {
        return LocalDate.parse(strDate, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime after(Long afterSeconds) {
        return LocalDateTime.now().plusSeconds(afterSeconds);
    }

    public static Date convertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
