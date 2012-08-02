package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.models.LoneWolf;

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
