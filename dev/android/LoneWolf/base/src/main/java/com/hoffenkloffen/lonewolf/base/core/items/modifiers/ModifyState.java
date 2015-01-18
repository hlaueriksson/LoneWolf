package com.hoffenkloffen.lonewolf.base.core.items.modifiers;

import com.hoffenkloffen.lonewolf.base.core.abstractions.ItemModifier;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.core.abstractions.CharacterState;

public class ModifyState implements ItemModifier {

    private CharacterState state;

    public ModifyState(CharacterState state) {
        this.state = state;
    }

    @Override
    public void modify(LoneWolf character) {
        // TODO: character.set(state);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + state.toString();
    }
}
