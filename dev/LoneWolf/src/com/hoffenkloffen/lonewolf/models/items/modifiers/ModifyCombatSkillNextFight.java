package com.hoffenkloffen.lonewolf.models.items.modifiers;

import com.hoffenkloffen.lonewolf.models.LoneWolf;

public class ModifyCombatSkillNextFight implements ItemModifier {
    private int delta;

    public ModifyCombatSkillNextFight(int delta) {
        this.delta = delta;
    }

    @Override
    public void modify(LoneWolf character) {
        // TODO: implement
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + delta;
    }
}
