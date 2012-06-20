package com.hoffenkloffen.lonewolf.controllers.combat.rules;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;
import com.hoffenkloffen.lonewolf.controllers.combat.modifiers.CombatModifier;
import com.hoffenkloffen.lonewolf.models.combat.CombatRound;
import com.hoffenkloffen.lonewolf.models.Item;
import com.hoffenkloffen.lonewolf.models.KaiDiscipline;
import com.hoffenkloffen.lonewolf.models.LoneWolf;

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

    public static ItemIsAcquired combatWith(Item item) {
        return new ItemIsAcquired(item);
    }

    public static ItemIsNotAcquired combatWithout(Item item) {
        return new ItemIsNotAcquired(item);
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
