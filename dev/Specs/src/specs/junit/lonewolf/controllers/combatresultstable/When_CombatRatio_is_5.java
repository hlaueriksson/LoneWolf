package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.CombatResultsTable;
import org.junit.Test;

public class When_CombatRatio_is_5 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(5);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 6, 4);
        assertEnduranceLoss(2, 7, 3);
        assertEnduranceLoss(3, 8, 3);
        assertEnduranceLoss(4, 9, 2);
        assertEnduranceLoss(5, 10, 2);
        assertEnduranceLoss(6, 11, 1);
        assertEnduranceLoss(7, 12, 0);
        assertEnduranceLoss(8, 14, 0);
        assertEnduranceLoss(9, 16, 0);
        assertEnduranceLoss(0, 18, 0);
    }
}
