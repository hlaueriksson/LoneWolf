package specs.junit.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.section.rules.GoldCrownsLessThan;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.items.GoldCrowns;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_GoldCrownsLessThan_10 extends Given_SectionRule {

    protected void given() {
        rule = new GoldCrownsLessThan(10);
    }

    @Test
    public void then_the_rule_should_match_on_GoldCrowns_8() {
        assertTrue(rule.match(get(new LoneWolf().add(new GoldCrowns(8)))));
    }

    @Test
    public void then_the_rule_should_match_on_GoldCrowns_9() {
        assertTrue(rule.match(get(new LoneWolf().add(new GoldCrowns(9)))));
    }

    @Test
    public void then_the_rule_should_not_match_on_GoldCrowns_10() {
        assertFalse(rule.match(get(new LoneWolf().add(new GoldCrowns(10)))));
    }

    @Test
    public void then_the_rule_should_not_match_on_GoldCrowns_11() {
        assertFalse(rule.match(get(new LoneWolf().add(new GoldCrowns(11)))));
    }

    @Test
    public void then_the_rule_should_not_match_on_GoldCrowns_12() {
        assertFalse(rule.match(get(new LoneWolf().add(new GoldCrowns(12)))));
    }
}
