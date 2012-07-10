package com.hoffenkloffen.lonewolf.controllers.combat.rules;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;
import com.hoffenkloffen.lonewolf.models.items.Item;

import java.util.Collection;

public class ItemIsAcquired extends BaseRule {
    private Item item;

    public ItemIsAcquired(Item item) {
        this.item = item;
    }

    @Override
    public boolean match(Collection<CombatState> states) {
        return false; // TODO: implement items
    }

    @Override
    public String toString() {
        return super.toString() + ": " + item.getName();
    }
}
