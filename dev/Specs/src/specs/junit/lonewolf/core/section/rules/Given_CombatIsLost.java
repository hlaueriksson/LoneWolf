package specs.junit.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.section.rules.CombatIsLost;
import com.hoffenkloffen.lonewolf.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.core.combat.Outcome;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_CombatIsLost extends Given_SectionRule {

    protected void given() {
        rule = new CombatIsLost();
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResult_Win() {
        assertFalse(rule.match(get(new CombatResult(Outcome.Win))));
    }

    @Test
    public void then_the_rule_should_match_on_state_with_CombatResult_Lose() {
        assertTrue(rule.match(get(new CombatResult(Outcome.Lose))));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_without_CombatResult() {
        assertFalse(rule.match(new ArrayList<SectionState>()));
    }
}
