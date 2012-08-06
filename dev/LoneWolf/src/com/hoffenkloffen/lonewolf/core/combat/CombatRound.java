package com.hoffenkloffen.lonewolf.core.combat;

import com.hoffenkloffen.lonewolf.core.abstractions.CombatState;

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
