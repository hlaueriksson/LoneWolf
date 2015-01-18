package com.hoffenkloffen.lonewolf.base.core.combat.combatresultstable;

import com.hoffenkloffen.lonewolf.base.core.combat.CombatResultsTable;

public class When_CombatRatio_is_6 extends When_CombatRatio_is_5 {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(6);
    }
}
