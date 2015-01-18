package com.hoffenkloffen.lonewolf.base.core;

import com.hoffenkloffen.lonewolf.base.core.abstractions.IItemManager;
import com.hoffenkloffen.lonewolf.base.core.items.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

public class ItemManager implements IItemManager {

    private Hashtable<String, Item> items = new Hashtable<String, Item>();

    public IItemManager add(Item item) {
        items.put(item.getName(), item);

        return this;
    }

    public Item get(Item item) {
        return items.get(item.getName());
    }

    public Collection<Item> get(Collection<Item> items) {
        Collection<Item> result = new ArrayList<Item>();

        for (Item item : items) {
            Item i = get(item);
            if(i != null) result.add(i); // TODO: warn
        }

        return result;
    }
}
