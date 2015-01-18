package com.hoffenkloffen.lonewolf.base.core.combat.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.base.core.character.KaiDiscipline;

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
