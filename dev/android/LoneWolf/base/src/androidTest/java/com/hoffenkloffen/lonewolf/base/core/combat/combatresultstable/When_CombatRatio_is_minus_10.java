package com.hoffenkloffen.lonewolf.base.core.combat.combatresultstable;

import com.hoffenkloffen.lonewolf.base.core.combat.CombatResultsTable;
import com.hoffenkloffen.lonewolf.base.core.combat.EnduranceLoss;
import org.junit.Test;

public class When_CombatRatio_is_minus_10 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(-10);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 0, EnduranceLoss.AutomaticallyKilled);
        assertEnduranceLoss(2, 0, 8);
        assertEnduranceLoss(3, 0, 7);
        assertEnduranceLoss(4, 1, 7);
        assertEnduranceLoss(5, 2, 6);
        assertEnduranceLoss(6, 3, 6);
        assertEnduranceLoss(7, 4, 5);
        assertEnduranceLoss(8, 5, 4);
        assertEnduranceLoss(9, 6, 3);
        assertEnduranceLoss(0, 7, 0);
    }
}
