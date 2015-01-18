package com.hoffenkloffen.lonewolf.base.core.section.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;

import java.util.Collection;

public class ItemIsInPossession extends BaseRule {

    private String item;

    public ItemIsInPossession(String item) {
        this.item = item;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        LoneWolf character = getLoneWolf(states);

        if(character == null) return false;

        return character.possess(item);
    }

    @Override
    public String toString() {
        return super.toString(item);
    }
}
