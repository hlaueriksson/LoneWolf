package com.hoffenkloffen.lonewolf.base.core.combat.combatresultstable;

import com.hoffenkloffen.lonewolf.base.core.combat.CombatResultsTable;
import org.junit.Test;

public class When_CombatRatio_is_0 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(0);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 3, 5);
        assertEnduranceLoss(2, 4, 4);
        assertEnduranceLoss(3, 5, 4);
        assertEnduranceLoss(4, 6, 3);
        assertEnduranceLoss(5, 7, 2);
        assertEnduranceLoss(6, 8, 2);
        assertEnduranceLoss(7, 9, 1);
        assertEnduranceLoss(8, 10, 0);
        assertEnduranceLoss(9, 11, 0);
        assertEnduranceLoss(0, 12, 0);
    }
}
