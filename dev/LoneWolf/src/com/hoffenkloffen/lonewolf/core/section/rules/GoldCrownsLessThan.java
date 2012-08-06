package com.hoffenkloffen.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;

import java.util.Collection;

public class GoldCrownsLessThan extends BaseRule {

    private int value;

    public GoldCrownsLessThan(int value) {
        this.value = value;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        LoneWolf character = getLoneWolf(states);

        if(character == null) return false;

        return character.getInventory().getGoldCrowns().getQuantity() < value;
    }

    @Override
    public String toString() {
        return super.toString(value);
    }
}