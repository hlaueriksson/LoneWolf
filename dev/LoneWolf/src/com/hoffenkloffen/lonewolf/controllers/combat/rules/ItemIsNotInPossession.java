package com.hoffenkloffen.lonewolf.controllers.combat.rules;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;

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
