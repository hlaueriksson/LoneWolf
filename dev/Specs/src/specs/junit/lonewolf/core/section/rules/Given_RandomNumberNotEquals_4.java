package specs.junit.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.section.rules.RandomNumberNotEquals;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberResult;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_RandomNumberNotEquals_4 extends Given_SectionRule {

    protected void given() {
        rule = new RandomNumberNotEquals(4);
    }

    @Test
    public void then_the_rule_should_match_on_0() {
        assertTrue(rule.match(get(new RandomNumberResult(0))));
    }

    @Test
    public void then_the_rule_should_match_on_3() {
        assertTrue(rule.match(get(new RandomNumberResult(3))));
    }

    @Test
    public void then_the_rule_should_not_match_on_4() {
        assertFalse(rule.match(get(new RandomNumberResult(4))));
    }

    @Test
    public void then_the_rule_should_match_on_5() {
        assertTrue(rule.match(get(new RandomNumberResult(5))));
    }

    @Test
    public void then_the_rule_should_match_on_9() {
        assertTrue(rule.match(get(new RandomNumberResult(9))));
    }

    @Test
    public void then_the_rule_should_match_on_no_random_number_result() {
        assertTrue(rule.match(new ArrayList<SectionState>()));
    }
}
