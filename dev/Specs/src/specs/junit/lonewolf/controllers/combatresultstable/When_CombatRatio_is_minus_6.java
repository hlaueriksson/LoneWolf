package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatResultsTable;
import org.junit.Test;

public class When_CombatRatio_is_minus_6 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(-6);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 0, 6);
        assertEnduranceLoss(2, 1, 6);
        assertEnduranceLoss(3, 2, 5);
        assertEnduranceLoss(4, 3, 5);
        assertEnduranceLoss(5, 4, 4);
        assertEnduranceLoss(6, 5, 4);
        assertEnduranceLoss(7, 6, 3);
        assertEnduranceLoss(8, 7, 2);
        assertEnduranceLoss(9, 8, 0);
        assertEnduranceLoss(0, 9, 0);
    }
}
