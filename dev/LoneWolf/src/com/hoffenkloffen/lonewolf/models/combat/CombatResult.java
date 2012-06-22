package com.hoffenkloffen.lonewolf.models.combat;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

public class CombatResult implements SectionState {

    private Outcome outcome;
    // TODO: rounds, AutomaticallyKilled

    public CombatResult(Outcome outcome) {
        this.outcome = outcome;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + getOutcome();
    }
}
