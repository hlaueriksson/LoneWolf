package specs.junit.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.controllers.section.rules.RandomNumberIsRolled;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import com.hoffenkloffen.lonewolf.models.RandomNumberResultList;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_RandomNumberIsRolled_for_index_1 extends Given_SectionRule {

    protected void given() {
        rule = new RandomNumberIsRolled(1);
    }

    @Test
    public void then_the_rule_should_match_on_state_with_RandomNumberResultList_0_0() {
        RandomNumberResultList list = new RandomNumberResultList();
        list.add(new RandomNumberResult(0));
        list.add(new RandomNumberResult(0));

        assertTrue(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_match_on_state_with_RandomNumberResultList_0() {
        RandomNumberResultList list = new RandomNumberResultList();
        list.add(new RandomNumberResult(0));

        assertFalse(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_RandomNumberResultList_empty() {
        RandomNumberResultList list = new RandomNumberResultList();

        assertFalse(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_without_RandomNumberResultList() {
        assertFalse(rule.match(new ArrayList<SectionState>()));
    }
}
