package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.models.combat.CombatResultList;
import com.hoffenkloffen.lonewolf.models.combat.Outcome;

import java.util.Collection;

public class CombatsAreFought extends BaseRule {

    @Override
    public boolean match(Collection<SectionState> states) {
        CombatResultList list = getCombatResultList(states);

        return list != null && list.getOutcome() == Outcome.Win;

    }
}
