package specs.junit.lonewolf.controllers.combat.combatratio;

import com.hoffenkloffen.lonewolf.controllers.combat.modifiers.ModifyCombatSkill;
import com.hoffenkloffen.lonewolf.controllers.combat.rules.OnRound;
import com.hoffenkloffen.lonewolf.models.combat.CombatRound;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Given_OnRound_1_ModifyCombatSkill_2 extends Given_CombatRatio {

    protected void given() {
        rules.add(new OnRound(1).then(new ModifyCombatSkill(2)));

        super.given();
    }

    @Test
    public void then_the_result_should_be_increased_by_2_on_the_first_round() {
        assertEquals(2, ratio.getResult(getStates()));
    }

    @Test
    public void then_the_result_should_not_be_increased_by_2_on_the_second_round() {
        round = new CombatRound(2);
        assertEquals(0, ratio.getResult(getStates()));
    }
}
