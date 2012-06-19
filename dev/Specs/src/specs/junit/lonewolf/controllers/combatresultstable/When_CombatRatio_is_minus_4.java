package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.CombatResultsTable;
import org.junit.Test;

public class When_CombatRatio_is_minus_4 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(-4);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 1, 6);
        assertEnduranceLoss(2, 2, 5);
        assertEnduranceLoss(3, 3, 5);
        assertEnduranceLoss(4, 4, 4);
        assertEnduranceLoss(5, 5, 4);
        assertEnduranceLoss(6, 6, 3);
        assertEnduranceLoss(7, 7, 2);
        assertEnduranceLoss(8, 8, 1);
        assertEnduranceLoss(9, 9, 0);
        assertEnduranceLoss(0, 10, 0);
    }
}
