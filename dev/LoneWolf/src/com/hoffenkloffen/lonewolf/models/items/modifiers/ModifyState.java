package com.hoffenkloffen.lonewolf.models.items.modifiers;

import com.hoffenkloffen.lonewolf.models.LoneWolf;
import com.hoffenkloffen.lonewolf.models.character.states.CharacterState;

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
