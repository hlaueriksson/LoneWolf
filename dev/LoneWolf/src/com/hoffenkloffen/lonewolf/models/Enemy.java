package com.hoffenkloffen.lonewolf.models;

public class Enemy {

    private String name;
    private int combatSkill;
    private int endurance;

    public Enemy(String name, int combatSkill, int endurance) {
        this.name = name;
        this.combatSkill = combatSkill;
        this.endurance = endurance;
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
}
