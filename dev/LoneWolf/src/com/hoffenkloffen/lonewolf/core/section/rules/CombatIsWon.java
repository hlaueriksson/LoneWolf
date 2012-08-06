package com.hoffenkloffen.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.core.combat.Outcome;

import java.util.Collection;

public class CombatIsWon extends BaseRule {

    @Override
    public boolean match(Collection<SectionState> states) {
        CombatResult result = getCombatResult(states);

        if(result == null) return false;

        return result.getOutcome() == Outcome.Win;
    }
}
