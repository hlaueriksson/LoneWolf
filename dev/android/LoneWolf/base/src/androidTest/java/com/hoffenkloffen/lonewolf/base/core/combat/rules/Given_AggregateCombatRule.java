package com.hoffenkloffen.lonewolf.base.core.combat.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatState;

import org.junit.Test;
import com.hoffenkloffen.lonewolf.base.support.combat.AlwaysFalse;
import com.hoffenkloffen.lonewolf.base.support.combat.AlwaysTrue;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_AggregateCombatRule extends Given_CombatRule {

    @Test
    public void then_the_rule_should_match_when_all_sub_rules_match() {
        rule = new AggregateCombatRule(new AlwaysTrue(), new AlwaysTrue());
        assertTrue(rule.match(new ArrayList<CombatState>()));
    }

    @Test
    public void then_the_rule_should_not_match_if_one_or_more_sub_rules_does_not_match() {
        rule = new AggregateCombatRule(new AlwaysTrue(), new AlwaysFalse());
        assertFalse(rule.match(new ArrayList<CombatState>()));
    }
}
