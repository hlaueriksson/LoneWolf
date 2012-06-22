package specs.junit.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.controllers.section.rules.CombatIsNotFought;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.combat.CombatResultList;
import com.hoffenkloffen.lonewolf.models.combat.Outcome;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_CombatIsNotFought_1 extends Given_SectionRule {

    protected void given() {
        rule = new CombatIsNotFought(1);
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResultList_Win_Win() {
        CombatResultList list = new CombatResultList(2);
        list.add(new CombatResult(Outcome.Win));
        list.add(new CombatResult(Outcome.Win));

        assertFalse(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResultList_Win_Lose() {
        CombatResultList list = new CombatResultList(2);
        list.add(new CombatResult(Outcome.Win));
        list.add(new CombatResult(Outcome.Lose));

        assertFalse(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResultList_Win() {
        CombatResultList list = new CombatResultList(2);
        list.add(new CombatResult(Outcome.Win));

        assertTrue(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResultList_empty() {
        CombatResultList list = new CombatResultList(2);

        assertTrue(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_without_CombatResultList() {
        assertTrue(rule.match(new ArrayList<SectionState>()));
    }
}
