package specs.junit.lonewolf.core.combat.combatresultstable;

import com.hoffenkloffen.lonewolf.core.combat.CombatResultsTable;
import com.hoffenkloffen.lonewolf.core.combat.EnduranceLoss;
import org.junit.Test;

public class When_CombatRatio_is_9 extends Given_CombatResultsTable {

    protected void given() {
        table = new CombatResultsTable();
        table.setCombatRatio(9);
    }

    @Test
    public void then_the_endurance_loss_should_correspond_to_the_official_rules() {

        assertEnduranceLoss(1, 8, 3);
        assertEnduranceLoss(2, 9, 3);
        assertEnduranceLoss(3, 10, 2);
        assertEnduranceLoss(4, 11, 2);
        assertEnduranceLoss(5, 12, 2);
        assertEnduranceLoss(6, 14, 1);
        assertEnduranceLoss(7, 16, 0);
        assertEnduranceLoss(8, 18, 0);
        assertEnduranceLoss(9, EnduranceLoss.AutomaticallyKilled, 0);
        assertEnduranceLoss(0, EnduranceLoss.AutomaticallyKilled, 0);
    }
}
