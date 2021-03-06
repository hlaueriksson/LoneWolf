package com.hoffenkloffen.lonewolf.base.core.combat;

import java.util.ArrayList;
import java.util.List;

public class Enemy {

    private String name;
    private int combatSkill;
    private int endurance;

    private List<Immunity> immunities = new ArrayList<Immunity>();

    public Enemy(String name, int combatSkill, int endurance) {
        this.name = name;
        this.combatSkill = combatSkill;
        this.endurance = endurance;
    }

    public Enemy add(Immunity immunity) {
        immunities.add(immunity);

        return this;
    }

    public String getName() {
        return name;
    }

    public int getCombatSkill() {
        return combatSkill;
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name);
        result.append(" CS; ");
        result.append(getCombatSkill());
        result.append(" EP; ");
        result.append(getEndurance());
        result.append(" ");

        return result.toString();
    }
}
