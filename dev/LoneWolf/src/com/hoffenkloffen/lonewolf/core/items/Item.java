package com.hoffenkloffen.lonewolf.core.items;

import com.hoffenkloffen.lonewolf.core.abstractions.ItemModifier;
import com.hoffenkloffen.lonewolf.core.items.modifiers.ModifyNothing;

public class Item implements Cloneable {
    protected String name;
    protected String description;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemModifier getModifier() {
        return new ModifyNothing();
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
