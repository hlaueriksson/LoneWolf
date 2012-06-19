package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.CombatResultsTable;

public class When_CombatRatio_is_6 extends When_CombatRatio_is_5 {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(6);
    }
}
