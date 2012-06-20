package com.hoffenkloffen.lonewolf.models;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;

import java.util.Hashtable;
import java.util.Map;

public class LoneWolf implements SectionState, CombatState {

    private int combatSkill;
    private int endurance;

    // CombatSkill; Initial, Modifier, Total
    // Endurance; Initial, Modifier, Total, Current

    private Hashtable<KaiDiscipline, Boolean> disciplines = new Hashtable<KaiDiscipline, Boolean>();

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
