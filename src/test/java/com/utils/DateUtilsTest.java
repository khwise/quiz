package com.utils;

import com.quiz.commons.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class DateUtilsTest {

    private static final Logger log = LoggerFactory.getLogger(DateUtilsTest.class);

    @Test
    public void test_localdatetime을_date로() {

        LocalDateTime now = LocalDateTime.now();

        Long afterSeconds = 1000L;
        Assert.assertTrue(now.isBefore(DateUtils.after(afterSeconds)));
        log.info(String.valueOf(DateUtils.convertToDate(DateUtils.after(afterSeconds)).getTime()));
    }
}
