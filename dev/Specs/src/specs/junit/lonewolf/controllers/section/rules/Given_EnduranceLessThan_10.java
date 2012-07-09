package specs.junit.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.rules.EnduranceLessThan;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_EnduranceLessThan_10 extends Given_SectionRule {

    protected void given() {
        rule = new EnduranceLessThan(10);
    }

    @Test
    public void then_the_rule_should_match_on_Endurance_8() {
        assertTrue(rule.match(get(new LoneWolf().setEndurance(8))));
    }

    @Test
    public void then_the_rule_should_match_on_Endurance_9() {
        assertTrue(rule.match(get(new LoneWolf().setEndurance(9))));
    }

    @Test
    public void then_the_rule_should_not_match_on_Endurance_10() {
        assertFalse(rule.match(get(new LoneWolf().setEndurance(10))));
    }

    @Test
    public void then_the_rule_should_not_match_on_Endurance_11() {
        assertFalse(rule.match(get(new LoneWolf().setEndurance(11))));
    }

    @Test
    public void then_the_rule_should_not_match_on_Endurance_12() {
        assertFalse(rule.match(get(new LoneWolf().setEndurance(12))));
    }
}
