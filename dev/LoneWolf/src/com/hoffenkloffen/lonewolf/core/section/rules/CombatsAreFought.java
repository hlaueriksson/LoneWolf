package com.hoffenkloffen.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.combat.CombatResultList;
import com.hoffenkloffen.lonewolf.core.combat.Outcome;

import java.util.Collection;

public class CombatsAreFought extends BaseRule {

    @Override
    public boolean match(Collection<SectionState> states) {
        CombatResultList list = getCombatResultList(states);

        return list != null && list.getOutcome() == Outcome.Win;

    }
}
