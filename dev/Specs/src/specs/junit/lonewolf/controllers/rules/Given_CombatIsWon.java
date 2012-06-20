package specs.junit.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.section.rules.CombatIsWon;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.Outcome;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_CombatIsWon extends Given_SectionRule {

    protected void given()
    {
        rule = new CombatIsWon();
    }

    @Test
    public void then_the_rule_should_match_on_state_with_CombatResult_Win()
    {
        assertTrue(rule.match(get(new CombatResult(Outcome.Win))));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResult_Lose()
    {
        assertFalse(rule.match(get(new CombatResult(Outcome.Lose))));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_without_CombatResult()
    {
        assertFalse(rule.match(new ArrayList<SectionState>()));
    }
}
