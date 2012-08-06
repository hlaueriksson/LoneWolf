package specs.junit.lonewolf.core.combat.combatresultlist;

import com.hoffenkloffen.lonewolf.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.core.combat.Outcome;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_Win extends Given_CombatResultList_with_3_enemies {

    protected void when() {
        list.add(new CombatResult(Outcome.Win));
    }

    @Test
    public void then_the_outcome_should_be_Pending() {
        assertEquals(Outcome.Pending, list.getOutcome());
    }
}
