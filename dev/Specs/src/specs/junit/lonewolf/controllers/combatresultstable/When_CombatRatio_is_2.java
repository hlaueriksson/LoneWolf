package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatResultsTable;

public class When_CombatRatio_is_2 extends When_CombatRatio_is_1 {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(2);
    }
}
