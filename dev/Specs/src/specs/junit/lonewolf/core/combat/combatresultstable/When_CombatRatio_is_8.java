package specs.junit.lonewolf.core.combat.combatresultstable;

import com.hoffenkloffen.lonewolf.core.combat.CombatResultsTable;

public class When_CombatRatio_is_8 extends When_CombatRatio_is_7 {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(8);
    }
}