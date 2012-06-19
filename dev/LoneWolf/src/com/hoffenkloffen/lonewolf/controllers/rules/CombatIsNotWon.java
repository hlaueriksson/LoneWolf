package com.hoffenkloffen.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;

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
