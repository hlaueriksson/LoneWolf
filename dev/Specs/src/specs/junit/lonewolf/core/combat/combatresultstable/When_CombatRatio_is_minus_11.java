package specs.junit.lonewolf.core.combat.combatresultstable;

import com.hoffenkloffen.lonewolf.core.combat.CombatResultsTable;
import com.hoffenkloffen.lonewolf.core.combat.EnduranceLoss;
import org.junit.Test;

public class When_CombatRatio_is_minus_11 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(-11);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 0, EnduranceLoss.AutomaticallyKilled);
        assertEnduranceLoss(2, 0, EnduranceLoss.AutomaticallyKilled);
        assertEnduranceLoss(3, 0, 8);
        assertEnduranceLoss(4, 0, 8);
        assertEnduranceLoss(5, 1, 7);
        assertEnduranceLoss(6, 2, 6);
        assertEnduranceLoss(7, 3, 5);
        assertEnduranceLoss(8, 4, 4);
        assertEnduranceLoss(9, 5, 3);
        assertEnduranceLoss(0, 6, 0);
    }
}
