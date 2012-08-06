package com.hoffenkloffen.lonewolf.core.combat.modifiers;

import com.hoffenkloffen.lonewolf.core.abstractions.CombatModifier;
import com.hoffenkloffen.lonewolf.core.abstractions.CombatValue;
import com.hoffenkloffen.lonewolf.core.combat.CombatSkillValue;

public class ModifyCombatSkill implements CombatModifier {
    private int delta;

    public ModifyCombatSkill(int delta) {
        this.delta = delta;
    }

    @Override
    public void modify(CombatValue value) {
        if (value instanceof CombatSkillValue) {
            CombatSkillValue cs = (CombatSkillValue) value;
            cs.setValue(cs.getValue() + delta);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + delta;
    }
}
