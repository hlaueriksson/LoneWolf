package com.hoffenkloffen.lonewolf.controllers.combat.rules;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;
import com.hoffenkloffen.lonewolf.models.Item;

import java.util.Collection;

public class ItemIsNotAcquired extends ItemIsAcquired {

    public ItemIsNotAcquired(Item item) {
        super(item);
    }

    @Override
    public boolean match(Collection<CombatState> states) {
        return !super.match(states);
    }
}
