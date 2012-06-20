package com.hoffenkloffen.lonewolf.models.combat;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;

public class CombatRound implements CombatState {
    private int number;

    public CombatRound(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void increment() {
        number++;
    }
}
