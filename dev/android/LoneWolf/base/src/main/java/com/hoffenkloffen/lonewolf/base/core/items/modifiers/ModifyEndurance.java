package com.hoffenkloffen.lonewolf.base.core.items.modifiers;

import com.hoffenkloffen.lonewolf.base.core.abstractions.ItemModifier;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;

public class ModifyEndurance implements ItemModifier {
    private int delta;

    public ModifyEndurance(int delta) {
        this.delta = delta;
    }

    @Override
    public void modify(LoneWolf character) {
        character.increaseEndurance(delta);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + delta;
    }
}
