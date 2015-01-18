package com.hoffenkloffen.lonewolf.base.core.items;

import com.hoffenkloffen.lonewolf.base.core.character.states.MealEaten;
import com.hoffenkloffen.lonewolf.base.core.abstractions.ItemModifier;
import com.hoffenkloffen.lonewolf.base.core.items.modifiers.ModifyState;

public class Meal extends Item {

    public Meal(String name) {
        super(name);
    }

    public Meal(String name, String description) {
        super(name, description);
    }

    @Override
    public ItemModifier getModifier() {
        return new ModifyState(new MealEaten());
    }
}
