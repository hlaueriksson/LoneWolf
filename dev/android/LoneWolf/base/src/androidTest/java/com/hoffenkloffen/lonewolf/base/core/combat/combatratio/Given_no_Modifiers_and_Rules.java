package com.hoffenkloffen.lonewolf.base.core.combat.combatratio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Given_no_Modifiers_and_Rules extends Given_CombatRatio {

    @Test
    public void then_the_result_should_not_be_modified() {
        assertEquals(0, ratio.getResult(getStates()));
    }
}
