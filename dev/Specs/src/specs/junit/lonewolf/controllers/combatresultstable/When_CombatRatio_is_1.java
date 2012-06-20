package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatResultsTable;
import org.junit.Test;

public class When_CombatRatio_is_1 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(1);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 4, 5);
        assertEnduranceLoss(2, 5, 4);
        assertEnduranceLoss(3, 6, 3);
        assertEnduranceLoss(4, 7, 3);
        assertEnduranceLoss(5, 8, 2);
        assertEnduranceLoss(6, 9, 2);
        assertEnduranceLoss(7, 10, 1);
        assertEnduranceLoss(8, 11, 0);
        assertEnduranceLoss(9, 12, 0);
        assertEnduranceLoss(0, 14, 0);
    }
}
