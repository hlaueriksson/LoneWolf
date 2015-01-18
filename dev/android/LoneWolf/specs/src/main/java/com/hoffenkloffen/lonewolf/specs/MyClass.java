package com.hoffenkloffen.lonewolf.specs;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyClass {
    @Test
    public void should_be_green() {
        assertThat(0, is(0));
    }
}
