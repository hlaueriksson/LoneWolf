package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.combat.Outcome;

import java.util.Collection;

public class CombatIsWon extends BaseRule {

    public CombatIsWon() {
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        CombatResult result = getCombatResult(states);

        if(result == null) return false;

        return result.getOutcome() == Outcome.Win;
    }
}
