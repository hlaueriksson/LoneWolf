package com.hoffenkloffen.lonewolf.base.core.items.modifiers;

import com.hoffenkloffen.lonewolf.base.core.abstractions.ItemModifier;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;

public class ModifyNothing implements ItemModifier {

    @Override
    public void modify(LoneWolf character) {
        // NOTE: do nothing
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
