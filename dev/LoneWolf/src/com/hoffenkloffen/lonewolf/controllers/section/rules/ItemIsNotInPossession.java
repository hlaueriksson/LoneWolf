package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

import java.util.Collection;

public class ItemIsNotInPossession extends ItemIsInPossession {

    public ItemIsNotInPossession(String item) {
        super(item);
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return !super.match(states);
    }
}
