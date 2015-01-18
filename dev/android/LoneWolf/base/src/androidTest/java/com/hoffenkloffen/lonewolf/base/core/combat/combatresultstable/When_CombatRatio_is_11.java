package com.hoffenkloffen.lonewolf.base.core.combat.combatresultstable;

import com.hoffenkloffen.lonewolf.base.core.combat.CombatResultsTable;
import com.hoffenkloffen.lonewolf.base.core.combat.EnduranceLoss;
import org.junit.Test;

public class When_CombatRatio_is_11 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(11);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 9, 3);
        assertEnduranceLoss(2, 10, 2);
        assertEnduranceLoss(3, 11, 2);
        assertEnduranceLoss(4, 12, 2);
        assertEnduranceLoss(5, 14, 1);
        assertEnduranceLoss(6, 16, 1);
        assertEnduranceLoss(7, 18, 0);
        assertEnduranceLoss(8, EnduranceLoss.AutomaticallyKilled, 0);
        assertEnduranceLoss(9, EnduranceLoss.AutomaticallyKilled, 0);
        assertEnduranceLoss(0, EnduranceLoss.AutomaticallyKilled, 0);
    }
}
