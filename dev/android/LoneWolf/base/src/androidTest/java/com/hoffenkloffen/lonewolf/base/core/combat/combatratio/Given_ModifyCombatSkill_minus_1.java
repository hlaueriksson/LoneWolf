package com.hoffenkloffen.lonewolf.base.core.combat.combatratio;

import com.hoffenkloffen.lonewolf.base.core.combat.modifiers.ModifyCombatSkill;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Given_ModifyCombatSkill_minus_1 extends Given_CombatRatio {

    protected void given() {
        modifiers.add(new ModifyCombatSkill(-1));

        super.given();
    }

    @Test
    public void then_the_result_should_be_decreased_by_1() {
        assertEquals(-1, ratio.getResult(getStates()));
    }
}
