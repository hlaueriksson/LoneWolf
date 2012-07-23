package com.hoffenkloffen.lonewolf.models.items.modifiers;

import com.hoffenkloffen.lonewolf.models.LoneWolf;

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
