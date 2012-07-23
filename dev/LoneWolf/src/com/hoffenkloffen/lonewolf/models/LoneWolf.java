package com.hoffenkloffen.lonewolf.models;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;
import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.models.character.Inventory;
import com.hoffenkloffen.lonewolf.models.items.GoldCrowns;
import com.hoffenkloffen.lonewolf.models.items.Item;
import com.hoffenkloffen.lonewolf.models.items.SpecialItem;
import com.hoffenkloffen.lonewolf.models.items.Weapon;

import java.util.Hashtable;
import java.util.Map;

public class LoneWolf implements SectionState, CombatState {

    private int combatSkill;
    private int endurance;

    // CombatSkill; Initial, Modifier, Total
    // Endurance; Initial, Modifier, Total, Current

    private Hashtable<KaiDiscipline, Boolean> disciplines = new Hashtable<KaiDiscipline, Boolean>();

    private Inventory inventory = new Inventory();

    public int getCombatSkill() {
        return combatSkill;
    }

    public LoneWolf setCombatSkill(int combatSkill) {
        this.combatSkill = combatSkill;

        return this;
    }

    public int getEndurance() {
        return endurance;
    }

    public LoneWolf setEndurance(int endurance) {
        this.endurance = endurance;

        return this;
    }

    public void reduceEndurance(int delta) {
        endurance -= delta;
    }

    public void increaseEndurance(int delta) {
        endurance += delta;
    }

    public LoneWolf add(KaiDiscipline discipline) {
        disciplines.put(discipline, true);

        return this;
    }

    public boolean acquired(KaiDiscipline discipline) {
        return disciplines.containsKey(discipline) && disciplines.get(discipline);
    }

    public LoneWolf add(Weapon weapon) { // TODO: delete, used only by specs
        inventory.add(weapon);

        return this;
    }

    public LoneWolf add(GoldCrowns crowns) {
        inventory.add(crowns);

        return this;
    }

    public LoneWolf add(Item item) {
        inventory.add(item);

        return this;
    }

    public LoneWolf add(SpecialItem item) {
        inventory.add(item);

        return this;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean possess(String item) {
        for (Item i : inventory.getBackpackItems()) {
            if (i.getName().equals(item)) return true;
        }

        for (Item i : inventory.getSpecialItems()) {
            if (i.getName().equals(item)) return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Lone Wolf:");
        result.append(" CS; ");
        result.append(getCombatSkill());
        result.append(" EP; ");
        result.append(getEndurance());
        result.append(" ");

        for (Map.Entry<KaiDiscipline, Boolean> entry : disciplines.entrySet()) {
            result.append(entry.getKey());
            result.append(", ");
        }

        result.append(inventory);

        return result.toString();
    }

    public void use(Item item) {
        item.getModifier().modify(this);
    }
}
