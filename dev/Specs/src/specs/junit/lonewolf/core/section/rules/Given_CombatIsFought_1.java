package specs.junit.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.section.rules.CombatIsFought;
import com.hoffenkloffen.lonewolf.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.core.combat.CombatResultList;
import com.hoffenkloffen.lonewolf.core.combat.Outcome;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_CombatIsFought_1 extends Given_SectionRule {

    protected void given() {
        rule = new CombatIsFought(1);
    }

    @Test
    public void then_the_rule_should_match_on_state_with_CombatResultList_Win_Win() {
        CombatResultList list = new CombatResultList(2);
        list.add(new CombatResult(Outcome.Win));
        list.add(new CombatResult(Outcome.Win));

        assertTrue(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_match_on_state_with_CombatResultList_Win_Lose() {
        CombatResultList list = new CombatResultList(2);
        list.add(new CombatResult(Outcome.Win));
        list.add(new CombatResult(Outcome.Lose));

        assertTrue(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResultList_Win() {
        CombatResultList list = new CombatResultList(2);
        list.add(new CombatResult(Outcome.Win));

        assertFalse(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResultList_empty() {
        CombatResultList list = new CombatResultList(2);

        assertFalse(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_without_CombatResultList() {
        assertFalse(rule.match(new ArrayList<SectionState>()));
    }
}
