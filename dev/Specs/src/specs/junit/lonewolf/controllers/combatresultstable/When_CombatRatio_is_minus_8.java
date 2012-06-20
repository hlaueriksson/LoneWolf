package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatResultsTable;
import org.junit.Test;

public class When_CombatRatio_is_minus_8 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(-8);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 0, 8);
        assertEnduranceLoss(2, 0, 7);
        assertEnduranceLoss(3, 1, 6);
        assertEnduranceLoss(4, 2, 6);
        assertEnduranceLoss(5, 3, 5);
        assertEnduranceLoss(6, 4, 5);
        assertEnduranceLoss(7, 5, 4);
        assertEnduranceLoss(8, 6, 3);
        assertEnduranceLoss(9, 7, 2);
        assertEnduranceLoss(0, 8, 0);
    }
}
