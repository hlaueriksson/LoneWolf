package com.hoffenkloffen.lonewolf.core.combat.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.CombatRule;
import com.hoffenkloffen.lonewolf.core.abstractions.CombatState;

import java.util.Collection;

public class AggregateCombatRule extends BaseRule {
    private CombatRule[] rules;

    public AggregateCombatRule(CombatRule... rules) {
        this.rules = rules;
    }

    @Override
    public boolean match(Collection<CombatState> states) {
        boolean result = true;

        for (CombatRule rule : rules) {
            result &= rule.match(states);
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());

        result.append(":\n");
        for (CombatRule rule : rules) {
            result.append(rule.toString());
            result.append(", ");
        }

        return result.toString();
    }
}
