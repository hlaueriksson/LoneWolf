package com.hoffenkloffen.lonewolf.base.core.random.randomnumbertable;

import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberTable;
import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberResult;
import org.junit.Test;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

import static org.junit.Assert.assertTrue;

public class Given_RandomNumberTable extends BaseSpec {

    private RandomNumberTable table;

    protected void given() {
        table = new RandomNumberTable();
    }

    @Test
    public void then_the_result_should_be_between_0_and_9() {
        RandomNumberResult result = table.getResult();
        assertTrue(result.getValue() >= 0);
        assertTrue(result.getValue() <= 9);
    }
}
