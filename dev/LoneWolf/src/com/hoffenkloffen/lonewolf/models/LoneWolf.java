package com.hoffenkloffen.lonewolf.models;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;
import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class LoneWolf implements SectionState, CombatState {

    private int combatSkill;
    private int endurance;

    // CombatSkill; Initial, Modifier, Total
    // Endurance; Initial, Modifier, Total, Current

    private Hashtable<KaiDiscipline, Boolean> disciplines = new Hashtable<KaiDiscipline, Boolean>();

    private List<Item> items = new ArrayList<Item>();

    public int getCombatSkill() {
        return combatSkill;
    }

    public void setCombatSkill(int combatSkill) {
        this.combatSkill = combatSkill;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void reduceEndurance(int delta) {
        endurance -= delta;
    }

    public LoneWolf add(KaiDiscipline discipline) {
        disciplines.put(discipline, true);

        return this;
    }

    public boolean acquired(KaiDiscipline discipline) {
        return disciplines.containsKey(discipline) && disciplines.get(discipline);
    }

    public LoneWolf add(Item item) {
        items.add(item);

        return this;
    }

    public boolean possess(String item) {
        for (Item i : items) {
            if(i.getName().equals(item)) return true;
        }

        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder("Lone Wolf:\n");

        for (Map.Entry<KaiDiscipline, Boolean> entry : disciplines.entrySet()) {
            result.append(entry.getKey());
            result.append(": ");
            result.append(entry.getValue());
            result.append("\n");
        }

        return result.toString();
    }
}
