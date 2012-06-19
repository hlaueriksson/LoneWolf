package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.CombatResultsTable;

public class When_CombatRatio_is_minus_1 extends When_CombatRatio_is_minus_2 {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(-1);
    }
}
