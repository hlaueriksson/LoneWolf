package com.hoffenkloffen.lonewolf.base.core.combat.combatresultstable;

import com.hoffenkloffen.lonewolf.base.core.combat.CombatResultsTable;
import com.hoffenkloffen.lonewolf.base.core.combat.EnduranceLoss;
import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberResult;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

import static junit.framework.Assert.assertEquals;

public class Given_CombatResultsTable extends BaseSpec {
    protected CombatResultsTable table;

    protected void assertEnduranceLoss(int randomNumberResult, int enduranceLossEnemy, int enduranceLossLoneWolf)
    {
        EnduranceLoss result = table.getEnduranceLoss(new RandomNumberResult(randomNumberResult));
        assertEquals(enduranceLossEnemy, result.getEnemyPoints());
        assertEquals(enduranceLossLoneWolf, result.getLoneWolfPoints());
    }
}
