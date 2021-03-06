package com.hoffenkloffen.lonewolf.base.core.combat.combatresultlist;

import com.hoffenkloffen.lonewolf.base.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.base.core.combat.Outcome;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_Win_Lose extends Given_CombatResultList_with_3_enemies {

    protected void when() {
        list.add(new CombatResult(Outcome.Win));
        list.add(new CombatResult(Outcome.Lose));
    }

    @Test
    public void then_the_outcome_should_be_Lose() {
        assertEquals(Outcome.Lose, list.getOutcome());
    }
}
