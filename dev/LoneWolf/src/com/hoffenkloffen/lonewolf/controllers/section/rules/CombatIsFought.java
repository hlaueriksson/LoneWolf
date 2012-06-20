package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

import java.util.Collection;

public class CombatIsFought extends BaseRule {

    public CombatIsFought() {
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return getCombatResult(states) != null;
    }
}
