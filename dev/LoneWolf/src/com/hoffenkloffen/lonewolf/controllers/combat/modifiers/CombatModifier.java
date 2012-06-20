package com.hoffenkloffen.lonewolf.controllers.combat.modifiers;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatValue;

public interface CombatModifier {

    void modify(CombatValue value);
}
