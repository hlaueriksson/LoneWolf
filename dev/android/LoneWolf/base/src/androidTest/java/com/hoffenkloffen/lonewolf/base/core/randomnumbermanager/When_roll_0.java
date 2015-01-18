package com.hoffenkloffen.lonewolf.base.core.randomnumbermanager;

import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberResultList;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class When_roll_0 extends Given_RandomNumberManager{

    protected void when() {
        manager.roll("0");
    }

    @Test
    public void then_the_section_state_should_contain_a_RandomNumberResultList_with_one_value() {
        RandomNumberResultList state = sectionManager.getCurrent().getState(RandomNumberResultList.class);
        assertNotNull(state);
        assertNotNull(state.get(0));
    }
}
