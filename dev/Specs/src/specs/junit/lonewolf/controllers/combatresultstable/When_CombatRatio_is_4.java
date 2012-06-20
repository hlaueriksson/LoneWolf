package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatResultsTable;

public class When_CombatRatio_is_4 extends When_CombatRatio_is_3 {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(4);
    }
}
