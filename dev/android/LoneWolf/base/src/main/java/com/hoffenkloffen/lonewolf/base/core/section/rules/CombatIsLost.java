package com.hoffenkloffen.lonewolf.base.core.section.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.base.core.combat.Outcome;

import java.util.Collection;

public class CombatIsLost extends BaseRule {

    @Override
    public boolean match(Collection<SectionState> states) {
        CombatResult result = getCombatResult(states);

        if(result == null) return false;

        return result.getOutcome() == Outcome.Lose;
    }
}
