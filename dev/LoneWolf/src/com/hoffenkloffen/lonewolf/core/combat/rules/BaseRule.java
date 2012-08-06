package com.hoffenkloffen.lonewolf.core.combat.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.CombatRule;
import com.hoffenkloffen.lonewolf.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.core.abstractions.CombatModifier;
import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.combat.CombatRound;

import java.util.Collection;

public abstract class BaseRule implements CombatRule {
    private CombatModifier modifier;

    @Override
    public CombatRule then(CombatModifier modifier) {
        this.modifier = modifier;

        return this;
    }

    @Override
    public CombatModifier getModifier() {
        return modifier;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public static KaiDisciplineIsAcquired combatWith(KaiDiscipline discipline) {
        return new KaiDisciplineIsAcquired(discipline);
    }

    public static KaiDisciplineIsNotAcquired combatWithout(KaiDiscipline discipline) {
        return new KaiDisciplineIsNotAcquired(discipline);
    }

    public static ItemIsInPossession combatWith(String item) {
        return new ItemIsInPossession(item);
    }

    public static ItemIsNotInPossession combatWithout(String item) {
        return new ItemIsNotInPossession(item);
    }

    protected LoneWolf getLoneWolf(Collection<CombatState> states) {
        for (CombatState state : states) {
            if(state instanceof LoneWolf) return (LoneWolf) state;
        }

        return null;
    }

    protected CombatRound getCombatRound(Collection<CombatState> states) {
        for (CombatState state : states) {
            if(state instanceof CombatRound) return (CombatRound) state;
        }

        return null;
    }
}
