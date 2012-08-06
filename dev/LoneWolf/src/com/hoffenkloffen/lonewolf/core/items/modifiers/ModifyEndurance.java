package com.hoffenkloffen.lonewolf.core.items.modifiers;

import com.hoffenkloffen.lonewolf.core.abstractions.ItemModifier;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;

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
