package com.hoffenkloffen.lonewolf.core.items;

import com.hoffenkloffen.lonewolf.core.character.states.MealEaten;
import com.hoffenkloffen.lonewolf.core.abstractions.ItemModifier;
import com.hoffenkloffen.lonewolf.core.items.modifiers.ModifyState;

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
