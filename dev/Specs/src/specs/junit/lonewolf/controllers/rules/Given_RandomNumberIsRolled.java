package specs.junit.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.section.rules.RandomNumberIsRolled;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_RandomNumberIsRolled extends Given_SectionRule {

    protected void given()
    {
        rule = new RandomNumberIsRolled();
    }

    @Test
    public void then_the_rule_should_match_on_state_with_RandomNumberResult()
    {
        assertTrue(rule.match(get(new RandomNumberResult(0))));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_without_RandomNumberResult()
    {
        assertFalse(rule.match(new ArrayList<SectionState>()));
    }
}
