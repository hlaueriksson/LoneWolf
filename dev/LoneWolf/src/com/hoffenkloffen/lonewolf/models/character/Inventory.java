package com.hoffenkloffen.lonewolf.models.character;

import com.hoffenkloffen.lonewolf.models.items.GoldCrowns;
import com.hoffenkloffen.lonewolf.models.items.Item;
import com.hoffenkloffen.lonewolf.models.items.SpecialItem;
import com.hoffenkloffen.lonewolf.models.items.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final class Max {
        static final int Weapons = 2;
        static final int GoldCrowns = 50;
        static final int BackpackItems = 8;
        static final int SpecialItems = 12;
    }

    private List<Weapon> weapons = new ArrayList<Weapon>(Max.Weapons);
    private GoldCrowns goldCrowns = new GoldCrowns(0);
    private List<Item> backpackItems = new ArrayList<Item>(Max.BackpackItems);
    private List<SpecialItem> specialItems = new ArrayList<SpecialItem>(Max.SpecialItems);

    public boolean add(Weapon weapon) {
        if (weapons.size() == Max.Weapons) return false;

        return weapons.add(weapon);
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public boolean add(GoldCrowns crowns) {
        int result = goldCrowns.getQuantity() + crowns.getQuantity();

        if (result > Max.GoldCrowns) {
            goldCrowns.setQuantity(Max.GoldCrowns);

            return false;
        }

        goldCrowns.setQuantity(result);

        return true;
    }

    public GoldCrowns getGoldCrowns() {
        return goldCrowns;
    }

    public boolean add(Item item) {
        if (backpackItems.size() == Max.BackpackItems) return false;

        return backpackItems.add(item);
    }

    public List<Item> getBackpackItems() {
        return backpackItems;
    }

    public boolean add(SpecialItem item) {
        if (specialItems.size() == Max.SpecialItems) return false;

        return specialItems.add(item);
    }

    public List<SpecialItem> getSpecialItems() {
        return specialItems;
    }
}
