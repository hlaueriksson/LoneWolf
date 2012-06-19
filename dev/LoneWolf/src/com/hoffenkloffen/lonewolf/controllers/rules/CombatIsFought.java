package com.hoffenkloffen.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;

import java.util.Collection;

public class CombatIsFought extends BaseRule {

    public CombatIsFought() {
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return getCombatResult(states) != null;
    }
}
