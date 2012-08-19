package com.hoffenkloffen.lonewolf.core.character;

import com.hoffenkloffen.lonewolf.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.items.GoldCrowns;
import com.hoffenkloffen.lonewolf.core.items.Item;
import com.hoffenkloffen.lonewolf.core.items.SpecialItem;
import com.hoffenkloffen.lonewolf.core.items.Weapon;

import java.util.HashSet;

public class LoneWolf implements SectionState, CombatState {

    private int combatSkill;
    private int endurance;

    // CombatSkill; Initial, Modifier, Total
    // Endurance; Initial, Modifier, Total, Current

    private HashSet<KaiDiscipline> disciplines = new HashSet<KaiDiscipline>();
    private Weaponskill weaponskill;

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
        disciplines.add(discipline);

        return this;
    }

    public LoneWolf remove(KaiDiscipline discipline) {
        disciplines.remove(discipline);

        return this;
    }

    public boolean acquired(KaiDiscipline discipline) {
        return disciplines.contains(discipline);
    }

    public KaiDiscipline[] getKaiDisciplines() {
        return disciplines.toArray(new KaiDiscipline[0]);
    }

    public Weaponskill getWeaponskill() {
        return weaponskill;
    }

    public void setWeaponskill(Weaponskill weaponskill) {
        this.weaponskill = weaponskill;
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
        if (item instanceof Weapon) add((Weapon) item);
        else if (item instanceof GoldCrowns) add((GoldCrowns) item);
        else if (item instanceof SpecialItem) add((SpecialItem) item);
        else inventory.add(item);

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
        for (Item i : inventory.getWeapons()) {
            if (i.getName().equals(item)) return true;
        }

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

        for (KaiDiscipline discipline : disciplines) {
            result.append(discipline);
            result.append(", ");
        }

        result.append(inventory);

        return result.toString();
    }

    public void use(Item item) {
        item.getModifier().modify(this);
    }
}
