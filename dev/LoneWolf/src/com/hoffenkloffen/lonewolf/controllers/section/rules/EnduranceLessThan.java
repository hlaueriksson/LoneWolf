package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.models.LoneWolf;

import java.util.Collection;

public class EnduranceLessThan extends BaseRule {

    private int value;

    public EnduranceLessThan(int value) {
        this.value = value;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        LoneWolf character = getLoneWolf(states);

        if(character == null) return false;

        return character.getEndurance() < value;
    }

    @Override
    public String toString() {
        return super.toString(value);
    }
}