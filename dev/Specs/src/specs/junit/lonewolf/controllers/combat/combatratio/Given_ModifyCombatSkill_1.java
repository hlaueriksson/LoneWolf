package specs.junit.lonewolf.controllers.combat.combatratio;

import com.hoffenkloffen.lonewolf.controllers.combat.modifiers.ModifyCombatSkill;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Given_ModifyCombatSkill_1 extends Given_CombatRatio {

    protected void given() {
        modifiers.add(new ModifyCombatSkill(1));

        super.given();
    }

    @Test
    public void then_the_result_should_be_increased_by_1() {
        assertEquals(1, ratio.getResult(getStates()));
    }
}
