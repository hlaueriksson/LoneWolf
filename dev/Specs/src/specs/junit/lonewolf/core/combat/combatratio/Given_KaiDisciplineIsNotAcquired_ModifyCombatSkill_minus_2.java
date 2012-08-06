package specs.junit.lonewolf.core.combat.combatratio;

import com.hoffenkloffen.lonewolf.core.combat.modifiers.ModifyCombatSkill;
import com.hoffenkloffen.lonewolf.core.combat.rules.KaiDisciplineIsNotAcquired;
import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Given_KaiDisciplineIsNotAcquired_ModifyCombatSkill_minus_2 extends Given_CombatRatio {

    protected void given() {
        rules.add(new KaiDisciplineIsNotAcquired(KaiDiscipline.Mindshield).then(new ModifyCombatSkill(-2)));

        super.given();
    }

    @Test
    public void then_the_result_should_be_decreased_by_2_if_the_discipline_is_not_acquired() {
        assertEquals(-2, ratio.getResult(getStates()));
    }

    @Test
    public void then_the_result_should_not_be_decreased_by_2_if_the_discipline_is_acquired() {
        character.add(KaiDiscipline.Mindshield);
        assertEquals(0, ratio.getResult(getStates()));
    }
}
