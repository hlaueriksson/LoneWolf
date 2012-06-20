package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatResultsTable;
import org.junit.Test;

public class When_CombatRatio_is_3 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(3);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 5, 4);
        assertEnduranceLoss(2, 6, 3);
        assertEnduranceLoss(3, 7, 3);
        assertEnduranceLoss(4, 8, 2);
        assertEnduranceLoss(5, 9, 2);
        assertEnduranceLoss(6, 10, 2);
        assertEnduranceLoss(7, 11, 1);
        assertEnduranceLoss(8, 12, 0);
        assertEnduranceLoss(9, 14, 0);
        assertEnduranceLoss(0, 16, 0);
    }
}
