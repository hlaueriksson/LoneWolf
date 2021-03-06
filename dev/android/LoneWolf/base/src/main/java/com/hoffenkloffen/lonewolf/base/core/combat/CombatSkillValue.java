package com.hoffenkloffen.lonewolf.base.core.combat;

import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatValue;

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
