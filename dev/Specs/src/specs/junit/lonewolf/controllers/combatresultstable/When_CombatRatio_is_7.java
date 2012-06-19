package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.CombatResultsTable;
import com.hoffenkloffen.lonewolf.controllers.EnduranceLoss;
import org.junit.Test;

public class When_CombatRatio_is_7 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(7);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 7, 4);
        assertEnduranceLoss(2, 8, 3);
        assertEnduranceLoss(3, 9, 2);
        assertEnduranceLoss(4, 10, 2);
        assertEnduranceLoss(5, 11, 2);
        assertEnduranceLoss(6, 12, 1);
        assertEnduranceLoss(7, 14, 0);
        assertEnduranceLoss(8, 16, 0);
        assertEnduranceLoss(9, 18, 0);
        assertEnduranceLoss(0, EnduranceLoss.AutomaticallyKilled, 0);
    }
}
