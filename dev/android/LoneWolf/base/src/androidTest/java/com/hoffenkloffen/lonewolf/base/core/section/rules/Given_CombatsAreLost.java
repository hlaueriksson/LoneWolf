package com.hoffenkloffen.lonewolf.base.core.section.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.base.core.combat.CombatResultList;
import com.hoffenkloffen.lonewolf.base.core.combat.Outcome;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_CombatsAreLost extends Given_SectionRule {

    protected void given() {
        rule = new CombatsAreLost();
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResultList_Win() {
        CombatResultList list = new CombatResultList(1);
        list.add(new CombatResult(Outcome.Win));

        assertFalse(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_match_on_state_with_CombatResultList_Lose() {
        CombatResultList list = new CombatResultList(1);
        list.add(new CombatResult(Outcome.Lose));

        assertTrue(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_with_CombatResultList_Pending() {
        CombatResultList list = new CombatResultList(1);

        assertFalse(rule.match(get(list)));
    }

    @Test
    public void then_the_rule_should_not_match_on_state_without_CombatResultList() {
        assertFalse(rule.match(new ArrayList<SectionState>()));
    }
}
