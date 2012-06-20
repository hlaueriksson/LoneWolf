package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

import java.util.Collection;

public class CombatIsNotWon extends CombatIsWon {

    public CombatIsNotWon() {
        super();
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return !super.match(states);
    }
}
