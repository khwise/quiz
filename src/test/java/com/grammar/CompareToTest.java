package com.grammar;

import org.junit.Test;


public class CompareToTest {

    @Test(expected = Exception.class)
    public void test_compareTo_null인_경우() {
        String a = "abcd";
        String b = null;
        a.compareTo(b);
    }
}
