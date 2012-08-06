package com.hoffenkloffen.lonewolf.core.combat.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.CombatState;

import java.util.Collection;

public class ItemIsNotInPossession extends ItemIsInPossession {

    public ItemIsNotInPossession(String item) {
        super(item);
    }

    @Override
    public boolean match(Collection<CombatState> states) {
        return !super.match(states);
    }
}
