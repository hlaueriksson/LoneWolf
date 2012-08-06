package com.hoffenkloffen.lonewolf.core.abstractions;

import java.util.Collection;

public interface CombatRule {

    // Init
    CombatRule then(CombatModifier modifier);

    // When
    boolean match(Collection<CombatState> states);

    // Then
    CombatModifier getModifier();
}
