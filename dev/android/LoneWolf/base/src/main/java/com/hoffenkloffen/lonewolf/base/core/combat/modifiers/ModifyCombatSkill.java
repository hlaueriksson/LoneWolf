package com.hoffenkloffen.lonewolf.base.core.combat.modifiers;

import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatModifier;
import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatValue;
import com.hoffenkloffen.lonewolf.base.core.combat.CombatSkillValue;

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
