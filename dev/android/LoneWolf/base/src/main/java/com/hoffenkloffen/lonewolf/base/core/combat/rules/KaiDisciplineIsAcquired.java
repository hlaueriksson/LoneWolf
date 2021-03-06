package com.hoffenkloffen.lonewolf.base.core.combat.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.base.core.character.KaiDiscipline;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;

import java.util.Collection;

public class KaiDisciplineIsAcquired extends BaseRule {
    private KaiDiscipline discipline;

    public KaiDisciplineIsAcquired(KaiDiscipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean match(Collection<CombatState> states) {
        LoneWolf character = getLoneWolf(states);

        if(character == null) return false;

        return character.acquired(discipline);
    }

    @Override
    public String toString() {
        return super.toString() + ": " + discipline;
    }
}
