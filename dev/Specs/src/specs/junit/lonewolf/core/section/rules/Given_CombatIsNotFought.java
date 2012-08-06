package specs.junit.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.section.rules.CombatIsNotFought;
import com.hoffenkloffen.lonewolf.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.core.combat.Outcome;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_CombatIsNotFought extends Given_SectionRule {

    protected void given() {
        rule = new CombatIsNotFought();
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResult() {
        assertFalse(rule.match(get(new CombatResult(Outcome.Win))));
    }

    @Test
    public void then_the_rule_should_match_on_state_without_RandomNumberResult() {
        assertTrue(rule.match(new ArrayList<SectionState>()));
    }
}
