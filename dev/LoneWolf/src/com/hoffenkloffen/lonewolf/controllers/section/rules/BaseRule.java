package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.controllers.section.injections.JavascriptInjection;
import com.hoffenkloffen.lonewolf.models.RandomNumberResultList;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import com.hoffenkloffen.lonewolf.models.combat.CombatResultList;

import java.util.Collection;

public abstract class BaseRule implements SectionRule {

    private JavascriptInjection javascriptInjection;

    @Override
    public SectionRule then(JavascriptInjection javascriptInjection) {
        this.javascriptInjection = javascriptInjection;

        return this;
    }

    @Override
    public JavascriptInjection getJavascriptInjection() {
        return javascriptInjection;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " > " + javascriptInjection.toString();
    }

    public String toString(Object value) {
        return getClass().getSimpleName() + ": " + value.toString() + " > " + javascriptInjection.toString();
    }

    protected LoneWolf getLoneWolf(Collection<SectionState> states) {
        for (SectionState state : states) {
            if(state instanceof LoneWolf) return (LoneWolf) state;
        }

        return null;
    }

    protected RandomNumberResult getRandomNumberResult(Collection<SectionState> states) {
        for (SectionState state : states) {
            if(state instanceof RandomNumberResult) return (RandomNumberResult) state;
        }

        return null;
    }

    protected RandomNumberResultList getRandomNumberResultList(Collection<SectionState> states) {
        for (SectionState state : states) {
            if(state instanceof RandomNumberResultList) return (RandomNumberResultList) state;
        }

        return null;
    }

    protected CombatResult getCombatResult(Collection<SectionState> states) {
        for (SectionState state : states) {
            if(state instanceof CombatResult) return (CombatResult) state;
        }

        return null;
    }

    protected CombatResultList getCombatResultList(Collection<SectionState> states) {
        for (SectionState state : states) {
            if(state instanceof CombatResultList) return (CombatResultList) state;
        }

        return null;
    }
}
