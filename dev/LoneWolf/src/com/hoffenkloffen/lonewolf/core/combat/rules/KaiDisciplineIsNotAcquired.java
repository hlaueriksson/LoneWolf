package com.hoffenkloffen.lonewolf.core.combat.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;

import java.util.Collection;

public class KaiDisciplineIsNotAcquired extends KaiDisciplineIsAcquired {

    public KaiDisciplineIsNotAcquired(KaiDiscipline discipline) {
        super(discipline);
    }

    @Override
    public boolean match(Collection<CombatState> states) {
        return !super.match(states);
    }
}
