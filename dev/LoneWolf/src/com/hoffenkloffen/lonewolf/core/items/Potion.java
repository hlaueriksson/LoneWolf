package com.hoffenkloffen.lonewolf.core.items;

import com.hoffenkloffen.lonewolf.core.abstractions.ItemModifier;

public class Potion extends Item {
    private ItemModifier modifier;

    public Potion(String name) {
        super(name);
    }

    public Potion(String name, String description, ItemModifier modifier) {
        super(name, description);

        this.modifier = modifier;
    }

    @Override
    public ItemModifier getModifier() {
        return modifier;
    }
}
