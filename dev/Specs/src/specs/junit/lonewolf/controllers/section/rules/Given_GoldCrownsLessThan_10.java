package specs.junit.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.rules.GoldCrownsLessThan;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_GoldCrownsLessThan_10 extends Given_SectionRule {

    protected void given() {
        rule = new GoldCrownsLessThan(10);
    }

    @Test
    public void then_the_rule_should_match_on_GoldCrowns_8() {
        assertTrue(rule.match(get(new LoneWolf().setGoldCrowns(8))));
    }

    @Test
    public void then_the_rule_should_match_on_GoldCrowns_9() {
        assertTrue(rule.match(get(new LoneWolf().setGoldCrowns(9))));
    }

    @Test
    public void then_the_rule_should_not_match_on_GoldCrowns_10() {
        assertFalse(rule.match(get(new LoneWolf().setGoldCrowns(10))));
    }

    @Test
    public void then_the_rule_should_not_match_on_GoldCrowns_11() {
        assertFalse(rule.match(get(new LoneWolf().setGoldCrowns(11))));
    }

    @Test
    public void then_the_rule_should_not_match_on_GoldCrowns_12() {
        assertFalse(rule.match(get(new LoneWolf().setGoldCrowns(12))));
    }
}
