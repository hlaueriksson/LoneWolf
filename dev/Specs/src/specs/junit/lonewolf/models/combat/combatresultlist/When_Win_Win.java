package specs.junit.lonewolf.models.combat.combatresultlist;

import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.combat.Outcome;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_Win_Win extends Given_CombatResultList_with_3_enemies {

    protected void when() {
        list.add(new CombatResult(Outcome.Win));
        list.add(new CombatResult(Outcome.Win));
    }

    @Test
    public void then_the_outcome_should_be_Pending() {
        assertEquals(Outcome.Pending, list.getOutcome());
    }
}
