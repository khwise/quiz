package com.grammar;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class VariableAddressAssignmentTest {

    @Test
    public void test_변수주소할당() {
        ArrayList<TempObject> list = new ArrayList();
        TempObject to;
        for (int i = 0; i < 10; i++) {
            to = new TempObject();
            to.setTemp(i);
            list.add(to);
        }

        Assert.assertEquals(0, list.get(0).getTemp());
        Assert.assertEquals(5, list.get(5).getTemp());
    }

    @Data
    class TempObject {
        private int temp;
    }
}
