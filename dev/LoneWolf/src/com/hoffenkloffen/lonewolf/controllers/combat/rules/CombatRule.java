package com.hoffenkloffen.lonewolf.controllers.combat.rules;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;
import com.hoffenkloffen.lonewolf.controllers.combat.modifiers.CombatModifier;

import java.util.Collection;

public interface CombatRule {

    // Init
    CombatRule then(CombatModifier modifier);

    // When
    boolean match(Collection<CombatState> states);

    // Then
    CombatModifier getModifier();
}
