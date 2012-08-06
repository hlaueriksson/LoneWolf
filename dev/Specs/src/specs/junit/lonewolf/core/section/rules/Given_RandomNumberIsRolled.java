package specs.junit.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.section.rules.RandomNumberIsRolled;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberResult;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_RandomNumberIsRolled extends Given_SectionRule {

    protected void given() {
        rule = new RandomNumberIsRolled();
    }

    @Test
    public void then_the_rule_should_match_on_state_with_RandomNumberResult() {
        assertTrue(rule.match(get(new RandomNumberResult(0))));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_without_RandomNumberResult() {
        assertFalse(rule.match(new ArrayList<SectionState>()));
    }
}
