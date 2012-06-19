package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.CombatResultsTable;

public class When_CombatRatio_is_12 extends When_CombatRatio_is_11 {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(12);
    }
}
