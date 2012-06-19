package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.CombatResultsTable;
import org.junit.Test;

public class When_CombatRatio_is_minus_2 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(-2);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 2, 5);
        assertEnduranceLoss(2, 3, 5);
        assertEnduranceLoss(3, 4, 4);
        assertEnduranceLoss(4, 5, 4);
        assertEnduranceLoss(5, 6, 3);
        assertEnduranceLoss(6, 7, 2);
        assertEnduranceLoss(7, 8, 2);
        assertEnduranceLoss(8, 9, 1);
        assertEnduranceLoss(9, 10, 0);
        assertEnduranceLoss(0, 11, 0);
    }
}
