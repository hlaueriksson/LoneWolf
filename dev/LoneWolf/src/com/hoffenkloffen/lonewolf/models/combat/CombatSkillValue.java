package com.hoffenkloffen.lonewolf.models.combat;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatValue;

public class CombatSkillValue implements CombatValue {
    private int value;

    public CombatSkillValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
