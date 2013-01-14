package specs.junit.lonewolf.core.combat.combatresultstable;

import com.hoffenkloffen.lonewolf.core.combat.CombatResultsTable;

public class When_CombatRatio_is_minus_7 extends When_CombatRatio_is_minus_8 {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(-7);
    }
}