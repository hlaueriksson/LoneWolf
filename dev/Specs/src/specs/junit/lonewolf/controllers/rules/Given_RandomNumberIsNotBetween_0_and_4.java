package specs.junit.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.section.rules.RandomNumberIsNotBetween;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_RandomNumberIsNotBetween_0_and_4 extends Given_SectionRule {

    protected void given()
    {
        rule = new RandomNumberIsNotBetween(0, 4);
    }

    @Test
    public void then_the_rule_should_not_match_on_0()
    {
        assertFalse(rule.match(get(new RandomNumberResult(0))));
    }

    @Test
    public void then_the_rule_should_not_match_on_2()
    {
        assertFalse(rule.match(get(new RandomNumberResult(2))));
    }

    @Test
    public void then_the_rule_should_not_match_on_4()
    {
        assertFalse(rule.match(get(new RandomNumberResult(4))));
    }

    @Test
    public void then_the_rule_should_match_on_5()
    {
        assertTrue(rule.match(get(new RandomNumberResult(5))));
    }

    @Test
    public void then_the_rule_should_match_on_7()
    {
        assertTrue(rule.match(get(new RandomNumberResult(7))));
    }

    @Test
    public void then_the_rule_should_match_on_9()
    {
        assertTrue(rule.match(get(new RandomNumberResult(9))));
    }

    @Test
    public void then_the_rule_should_match_on_no_random_number_result()
    {
        assertTrue(rule.match(new ArrayList<SectionState>()));
    }
}
