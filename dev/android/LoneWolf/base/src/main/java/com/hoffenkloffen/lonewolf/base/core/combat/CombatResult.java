package com.hoffenkloffen.lonewolf.base.core.combat;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;

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
