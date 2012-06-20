package com.hoffenkloffen.lonewolf.controllers.combat.rules;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;
import com.hoffenkloffen.lonewolf.models.KaiDiscipline;
import com.hoffenkloffen.lonewolf.models.LoneWolf;

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
