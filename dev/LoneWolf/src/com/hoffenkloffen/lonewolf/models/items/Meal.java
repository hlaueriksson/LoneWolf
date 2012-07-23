package com.hoffenkloffen.lonewolf.models.items;

import com.hoffenkloffen.lonewolf.models.items.modifiers.ItemModifier;
import com.hoffenkloffen.lonewolf.models.items.modifiers.ModifyEndurance;

public class Meal extends Item {

    public Meal(String name) {
        super(name);
    }

    public Meal(String name, String description) {
        super(name, description);
    }

    @Override
    public ItemModifier getModifier() {
        return new ModifyEndurance(3);
    }
}
