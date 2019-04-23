package com.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ObjectMapperTest {

    private ObjectMapper mapper;

    private TestClass tc;

    @Before
    public void setup() {
        mapper = new ObjectMapper();
        tc = new TestClass();

        tc.setA("AAA");
        tc.setB("BBB");
    }

    /*
     *  [object mapper]
     *  public 변수는 write 한다.
     *  private 변수는 get 메소드를 통해서 write 한다.
     */

    @Test
    public void test_objectmapper_deserialize_동작확인() throws IOException {

        tc.c = "CCCC";

        Assert.assertEquals("{\"a\":\"AAABBB\",\"b\":\"BBB\"}", mapper.writeValueAsString(tc));
    }

    @Setter
    class TestClass {

        private String a;

        private String b;

        public String c;

        public String getA() {
            return a + b;
        }
    }
}
