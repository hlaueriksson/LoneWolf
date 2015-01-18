package com.hoffenkloffen.lonewolf.base.core.section.injections;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberResult;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Given_DisplayRandomNumber extends Given_JavascriptInjection {

    protected void given() {
        injection = new DisplayRandomNumber();
    }

    @Test
    public void then_the_script_should_display_the_random_number_result() {
        assertEquals("displayRandomNumber(0);", injection.getScript(get(new RandomNumberResult(0))));
    }

    @Test
    public void then_the_script_should_be_empty_on_no_random_number_result() {
        assertEquals("", injection.getScript(new ArrayList<SectionState>()));
    }
}
