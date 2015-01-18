package com.hoffenkloffen.lonewolf.base.core.combat.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatState;

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
