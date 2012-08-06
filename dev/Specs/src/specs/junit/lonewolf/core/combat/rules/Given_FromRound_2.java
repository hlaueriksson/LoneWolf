package specs.junit.lonewolf.core.combat.rules;

import com.hoffenkloffen.lonewolf.core.combat.rules.FromRound;
import com.hoffenkloffen.lonewolf.core.combat.CombatRound;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_FromRound_2 extends Given_CombatRule {

    protected void given() {
        rule = new FromRound(2);
    }

    @Test
    public void then_the_rule_should_not_match_on_round_1() {
        assertFalse(rule.match(get(new CombatRound(1))));
    }

    @Test
    public void then_the_rule_should_match_on_round_2() {
        assertTrue(rule.match(get(new CombatRound(2))));
    }

    @Test
    public void then_the_rule_should_match_on_round_3() {
        assertTrue(rule.match(get(new CombatRound(3))));
    }
}
