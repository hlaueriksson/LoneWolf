package com.hoffenkloffen.lonewolf.models.items.modifiers;

import com.hoffenkloffen.lonewolf.models.LoneWolf;

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
