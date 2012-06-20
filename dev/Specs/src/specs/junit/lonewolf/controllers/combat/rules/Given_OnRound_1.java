package specs.junit.lonewolf.controllers.combat.rules;

import com.hoffenkloffen.lonewolf.controllers.combat.rules.OnRound;
import com.hoffenkloffen.lonewolf.models.combat.CombatRound;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_OnRound_1 extends Given_CombatRule {

    protected void given() {
        rule = new OnRound(1);
    }

    @Test
    public void then_the_rule_should_match_on_round_1() {
        assertTrue(rule.match(get(new CombatRound(1))));
    }

    @Test
    public void then_the_rule_should_not_match_on_round_2() {
        assertFalse(rule.match(get(new CombatRound(2))));
    }
}
