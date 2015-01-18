package com.hoffenkloffen.lonewolf.base.core.section.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;

import java.util.Collection;

public class EnduranceGreaterThan extends BaseRule {

    private int value;

    public EnduranceGreaterThan(int value) {
        this.value = value;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        LoneWolf character = getLoneWolf(states);

        if(character == null) return false;

        return character.getEndurance() > value;
    }

    @Override
    public String toString() {
        return super.toString(value);
    }
}
